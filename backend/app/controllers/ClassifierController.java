package controllers;

import javax.inject.Inject;

import java.io.File;
import java.nio.file.*;

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

public class ClassifierController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public ClassifierController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

}
