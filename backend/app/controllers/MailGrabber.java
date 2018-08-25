package controllers;

import javax.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.DynamicForm;
import play.data.FormFactory;

public class MailGrabber extends Controller {

    private final FormFactory formFactory;

    @Inject
    public MailGrabber(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result newMail() {
        DynamicForm form = formFactory.form().bindFromRequest();
        if(form.data().size() == 0) {
            return badRequest("No mail sent.");
        } else {
            return ok("E-Mail from " + form.get("sender") + " received.");
        }
    }

}
