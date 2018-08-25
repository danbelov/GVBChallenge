// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/RSQLAPTOP/Documents/GVBChallenge/backend/conf/routes
// @DATE:Sat Aug 25 19:14:27 CEST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseDamageReportController DamageReportController = new controllers.ReverseDamageReportController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMailGrabber MailGrabber = new controllers.ReverseMailGrabber(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseDamageReportController DamageReportController = new controllers.javascript.ReverseDamageReportController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMailGrabber MailGrabber = new controllers.javascript.ReverseMailGrabber(RoutesPrefix.byNamePrefix());
  }

}
