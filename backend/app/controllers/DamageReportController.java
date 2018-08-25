package controllers;

import play.mvc.*;

import models.DamageReport;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class DamageReportController extends Controller {

    public Result createDamageReport() {
        return ok();
    }

    public Result getDamageReport(long id) {
        return ok(((DamageReport)models.DamageReport.find.byId(id)).id.toString());
    }

}
