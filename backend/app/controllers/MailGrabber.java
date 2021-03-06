package controllers;

import javax.inject.Inject;

import mail.MailSender;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.DynamicForm;
import play.data.FormFactory;


import io.ebean.Ebean;
import io.ebean.EbeanServer;

import org.joda.time.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.*;
import enums.*;

import java.util.List;

public class MailGrabber extends Controller {

    private final FormFactory formFactory;

    private static final String ServerAddress = "http://142.93.107.12/";

    private static final String PHPIntermediaryPage = "submit-report.php";

    @Inject
    public MailGrabber(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result newMail() {
        System.out.println("");
        DynamicForm form = formFactory.form().bindFromRequest();
        Object[] keys = form.rawData().keySet().toArray();
        for(int i=0;i<keys.length;i++) {
            System.out.println("Got field: " + ((String)keys[i]) + " with value " + form.get(((String)keys[i])));
        }
        if(form.data().size() == 0) {
            return badRequest("No mail sent.");
        } else {
            EbeanServer server = Ebean.getDefaultServer();

            DamageReport report = new DamageReport();
            report.status = "Waiting for customer";
            report.email = form.get("sender");
            report.damageDate = new DateTime().getMillis();
            server.save(report);

            DamageReport rep = DamageReport.find.byId(report.id);
            Event event = new Event();
            event.type = EventType.EMAIL;
            event.time = new DateTime().getMillis();
            event.text = form.get("msg");
            rep.events.add(event);
            server.save(rep);

            MailSender mailSender = new MailSender();

            mailSender.sendMail(report.email,
                    "Ihre Anfrage bei der GVB",
                    "Sehr geehrte Damen und Herren, " +
                            "bitte vervollständigen Sie Ihre Anfrage."
                            +" Diese können Sie unter dem " +
                            "folgenden Link finden: " + ServerAddress
                                                      + PHPIntermediaryPage
                                                      + "?id=" + rep.id
                                                      + "&email=" + rep.email);

            System.out.println("E-Mail from " + rep.email + " received, id: " + rep.id + ", msg: " + rep.events.get(0).text);
            return ok("E-Mail from " + rep.email + " received, id: " + rep.id + ", msg: " + rep.events.get(0).text);
        }
    }

}
