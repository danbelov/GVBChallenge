package controllers;

import javax.inject.Inject;

import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;

import mail.MailSender;
import play.mvc.*;
import play.libs.Json;

import org.joda.time.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.DynamicForm;
import play.data.FormFactory;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

import org.joda.time.*;

import models.*;
import enums.*;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import subprocesses.ClassifierThread;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class DamageReportController extends Controller {

    private final FormFactory formFactory;

    private static final String ServerAddress = "http://142.93.107.12/";

    private static final String PHPIntermediaryPage = "overview.php";

    @Inject
    public DamageReportController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result changeStatus(Long id) {
        System.out.println("Changing status of " + id);
        EbeanServer server = Ebean.getDefaultServer();
        DynamicForm form = formFactory.form().bindFromRequest();
        Object[] keys = form.rawData().keySet().toArray();
        for(int i=0;i<keys.length;i++) {
            System.out.println("Got field: " + ((String)keys[i]) + " with value " + form.get(((String)keys[i])));
        }
        DamageReport rep = DamageReport.find.byId(id);
        rep.status = form.get("status");
        server.save(rep);
        System.out.println("Status changed to " + form.get("status"));
        return ok();
    }

    public Result createImage() {
        EbeanServer server = Ebean.getDefaultServer();
        DynamicForm form = formFactory.form().bindFromRequest();

        Http.MultipartFormData<File> formData = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> image = formData.getFile("image");
        String contentType = image.getContentType();
        File file = image.getFile();

        DBImage img = new DBImage();
        img.mime = contentType;
        try {
            img.image = Files.readAllBytes(file.toPath());
        } catch (java.io.IOException e) {}
        img.description = form.get("description");

        DamageReport rep = DamageReport.find.byId(Long.parseLong(form.get("report-id")));
        rep.images.add(img);
        server.save(rep);

        System.out.println("Added image " + img.id + " to report " + rep.id);
        return ok("" + img.id);
    }

    public Result getImage(Long id) {
        EbeanServer server = Ebean.getDefaultServer();
        DBImage img = DBImage.find.byId(id);
        response().setContentType(img.mime);
        response().setHeader("X-Image-Description", img.description);
        response().setHeader("Content-Disposition", "attachment; filename=" + id);
        return ok(img.image);
    }

    public Result getImages() {
        return ok(Json.toJson(models.DBImage.find.all()));
    }

    public Result getRepImages(Long id) {
        DamageReport rep = DamageReport.find.byId(id);
        return ok(Json.toJson(DBImage.find.query().where().eq("damageReport", rep).findList()));
    }

    public Result createEvent() {
        EbeanServer server = Ebean.getDefaultServer();
        DynamicForm form = formFactory.form().bindFromRequest();

        Event event = new Event();
        event.time = new DateTime().getMillis();
        event.type = EventType.valueOf(form.get("type"));
        event.text = form.get("text");

        DamageReport rep = DamageReport.find.byId(Long.parseLong(form.get("report-id")));
        rep.events.add(event);
        server.save(rep);

        return ok("" + event.id);
    }

    public Result getEvent(Long id) {
        return ok(Json.toJson(Event.find.byId(id)));
    }

    private Double calcFraudScore(DamageReport rep) {
        ObjectNode json = (ObjectNode)Json.parse("{}");
        System.out.println(json);
        json.put("Vandalismus", (rep.damageSource.equals("Vandalismus") ? 1 : 0))
        .put("Uberschwemmung", (rep.damageSource.equals("Uberschwemmung") ? 1 : 0))
        .put("Offerte vorhanden", (rep.offerExists ? 1 : 0))
        .put("Feuer", (rep.damageSource.equals("Feuer") ? 1 : 0))
        .put("Regenwasser", (rep.damageSource.equals("Regenwasser") ? 1 : 0))
        .put("Gebaudetechnik", (rep.damageSource.equals("Gebaudetechnik") ? 1 : 0))
        .put("Eigenleistung", (rep.selfEstimated ? 1 : 0))
        .put("Sturmwind", (rep.damageSource.equals("Sturmwind") ? 1 : 0))
        .put("Rechnung vorhanden?", (rep.billExists ? 1 : 0))
        .put("Grundwasser", (rep.damageSource.equals("Grundwasser") ? 1 : 0))
        .put("Hagel", (rep.damageSource.equals("Hagel") ? 1 : 0))
        .put("Leitungsbruch", (rep.damageSource.equals("Leitungsbruch") ? 1 : 0))
        .put("Glasbruch", (rep.damageSource.equals("Glasbruch") ? 1 : 0))
        .put("Marder", (rep.damageSource.equals("Marder") ? 1 : 0))
        .put("Schaden behoben", 0)
        .put("Selbsteinsch", (rep.selfEstimated ? 1 : 0))
        .put("Blitzschlag", (rep.damageSource.equals("Blitzschlag") ? 1 : 0))
        .put("Hochwasser", (rep.damageSource.equals("Hochwasser") ? 1 : 0))
        .put("Erdrutsch", (rep.damageSource.equals("Erdrutsch") ? 1 : 0))
        .put("uberspannung bei Gewitter", (rep.damageSource.equals("uberspannung bei Gewitter") ? 1 : 0))
        .put("Fachauskunft", (rep.damageSource.equals("Fachauskunft") ? 1 : 0));
        return ClassifierThread.runClassifier(json);
        //return 0.0;
    }

    public Result createDamageReport() {
        EbeanServer server = Ebean.getDefaultServer();
        DynamicForm form = formFactory.form().bindFromRequest();

        DamageReport rep = new DamageReport();
        rep.status = form.get("status");
        rep.fraudScore = (form.get("fraudScore") != null && form.get("fraudScore").length() > 0) ? Double.parseDouble(form.get("fraudScore")) : 0;
        rep.policeNr = form.get("policeNr");
        rep.name = form.get("name");
        rep.email = form.get("email");
        rep.damageDate = (form.get("damageDate") != null && form.get("damageDate").length() > 0) ? Long.parseLong(form.get("damageDate")) : new DateTime().getMillis();
        rep.damageSource = (form.get("damageSource") != null ? form.get("damageSource") : "");
        rep.damagedItems = form.get("damagedItems");
        rep.damageDescription = form.get("damageDescription");
        rep.otherInformations = form.get("otherInformations");
        rep.offerExists = (form.get("offerExists") != null && form.get("offerExists").length() > 0) ? Boolean.parseBoolean(form.get("offerExists")) : false;
        rep.costs = (form.get("costs") != null && form.get("costs").length() > 0) ? Double.parseDouble(form.get("costs")) : 0;
        rep.selfEstimated = (form.get("selfEstimated") != null && form.get("selfEstimated").length() > 0) ? Boolean.parseBoolean(form.get("selfEstimated")) : false;
        rep.billExists = (form.get("billExists") != null && form.get("billExists").length() > 0) ? Boolean.parseBoolean(form.get("billExists")) : false;

        rep.fraudScore = calcFraudScore(rep);
        server.save(rep);

        return ok(""+rep.id);
    }

    public Result updateDamageReport() {
        EbeanServer server = Ebean.getDefaultServer();

        DynamicForm form = formFactory.form().bindFromRequest();
        DamageReport rep = DamageReport.find.byId(Long.parseLong(form.get("id")));
        rep.status = form.get("status");
        rep.fraudScore = Double.parseDouble(form.get("fraudScore"));
        rep.policeNr = form.get("policeNr");
        rep.name = form.get("name");
        rep.email = form.get("email");
        rep.damageDate = Long.parseLong(form.get("damageDate"));
        rep.damageSource = form.get("damageSource");
        rep.damagedItems = form.get("damagedItems");
        rep.damageDescription = form.get("damageDescription");
        rep.otherInformations = form.get("otherInformations");
        rep.offerExists = Boolean.parseBoolean(form.get("offerExists"));
        rep.costs = Double.parseDouble(form.get("costs"));
        rep.selfEstimated = Boolean.parseBoolean(form.get("selfEstimated"));
        rep.billExists = Boolean.parseBoolean(form.get("billExists"));

        server.save(rep);

        MailSender mailSender = new MailSender();

        mailSender.sendMail(rep.email,
                      "Status von Ihrer Anfrage hat sich in der Zwischenzeit verändert",
                        "Sehr geehrte Damen und Herren, " +
                                "der Status von Ihrer Anfrage " +
                                "hat sich in der Zwischenzeit verändert."
                                +" Diese können Sie jedes mal " +
                                "online unter " +
                                "folgendem Link verfolgen: " + ServerAddress
                                + PHPIntermediaryPage
                                + "?id=" + rep.id
                                + "&email=" + rep.email);

        return ok();
    }

    public Result getDamageReport(long id) {
        //return ok(((DamageReport)models.DamageReport.find.byId(id)).id.toString());
        return ok(Json.toJson(models.DamageReport.find.byId(id)));
    }

    public Result getDamageReports() {
        return ok(Json.toJson(models.DamageReport.find.all()));
    }

}
