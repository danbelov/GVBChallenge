// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/RSQLAPTOP/Documents/GVBChallenge/backend/conf/routes
// @DATE:Sat Aug 25 19:14:27 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:11
  class ReverseDamageReportController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def getDamageReport(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "DamageReport/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:17
    def getEvent(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "Event/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:19
    def createDamageReport(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "DamageReport")
    }
  
    // @LINE:20
    def updateDamageReport(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "DamageReport")
    }
  
    // @LINE:16
    def createEvent(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "Event")
    }
  
    // @LINE:22
    def getDamageReports(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "DamageReport")
    }
  
    // @LINE:14
    def getImage(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "Image/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:11
    def changeStatus(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ChangeStatus/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:13
    def createImage(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "Image")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:24
  class ReverseMailGrabber(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def newMail(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "email")
    }
  
  }


}
