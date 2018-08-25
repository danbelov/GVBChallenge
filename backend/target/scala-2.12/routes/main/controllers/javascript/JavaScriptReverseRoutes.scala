// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/RSQLAPTOP/Documents/GVBChallenge/backend/conf/routes
// @DATE:Sat Aug 25 19:14:27 CEST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:11
  class ReverseDamageReportController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def getDamageReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.getDamageReport",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "DamageReport/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def getEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.getEvent",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Event/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:19
    def createDamageReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.createDamageReport",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "DamageReport"})
        }
      """
    )
  
    // @LINE:20
    def updateDamageReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.updateDamageReport",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "DamageReport"})
        }
      """
    )
  
    // @LINE:16
    def createEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.createEvent",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "Event"})
        }
      """
    )
  
    // @LINE:22
    def getDamageReports: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.getDamageReports",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "DamageReport"})
        }
      """
    )
  
    // @LINE:14
    def getImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.getImage",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Image/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:11
    def changeStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.changeStatus",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ChangeStatus/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:13
    def createImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DamageReportController.createImage",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "Image"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseMailGrabber(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def newMail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MailGrabber.newMail",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "email"})
        }
      """
    )
  
  }


}
