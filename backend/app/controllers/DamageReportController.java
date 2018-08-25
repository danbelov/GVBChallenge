package controllers;

import javax.inject.Inject;

import java.io.File;
import java.nio.file.*;

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

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class DamageReportController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public DamageReportController(FormFactory formFactory) {
        this.formFactory = formFactory;
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
        server.save(img);

        DamageReport rep = DamageReport.find.byId(Long.parseLong(form.get("report-id")));
        rep.images.add(img);
        server.save(rep);

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

    public Result createEvent() {
        EbeanServer server = Ebean.getDefaultServer();
        DynamicForm form = formFactory.form().bindFromRequest();

        Event event = new Event();
        event.time = new DateTime().getMillis();
        event.type = EventType.valueOf(form.get("type"));
        event.text = form.get("text");
        server.save(event);

        DamageReport rep = DamageReport.find.byId(Long.parseLong(form.get("report-id")));
        rep.events.add(event);
        server.save(rep);

        return ok("" + event.id);
    }

    public Result getEvent(Long id) {
        return ok(Json.toJson(Event.find.byId(id)));
    }

    public Result createDamageReport() {
        EbeanServer server = Ebean.getDefaultServer();
        DynamicForm form = formFactory.form().bindFromRequest();

        DamageReport rep = new DamageReport();
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
