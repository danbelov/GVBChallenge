// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/RSQLAPTOP/Documents/GVBChallenge/backend/conf/routes
// @DATE:Sat Aug 25 19:14:27 CEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:11
  DamageReportController_2: controllers.DamageReportController,
  // @LINE:24
  MailGrabber_1: controllers.MailGrabber,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:11
    DamageReportController_2: controllers.DamageReportController,
    // @LINE:24
    MailGrabber_1: controllers.MailGrabber
  ) = this(errorHandler, HomeController_0, DamageReportController_2, MailGrabber_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, DamageReportController_2, MailGrabber_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ChangeStatus/""" + "$" + """id<[^/]+>""", """controllers.DamageReportController.changeStatus(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Image""", """controllers.DamageReportController.createImage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Image/""" + "$" + """id<[^/]+>""", """controllers.DamageReportController.getImage(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Event""", """controllers.DamageReportController.createEvent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Event/""" + "$" + """id<[^/]+>""", """controllers.DamageReportController.getEvent(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """DamageReport""", """controllers.DamageReportController.createDamageReport()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """DamageReport""", """controllers.DamageReportController.updateDamageReport()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """DamageReport/""" + "$" + """id<[^/]+>""", """controllers.DamageReportController.getDamageReport(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """DamageReport""", """controllers.DamageReportController.getDamageReports()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """email""", """controllers.MailGrabber.newMail()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_DamageReportController_changeStatus1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ChangeStatus/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DamageReportController_changeStatus1_invoker = createInvoker(
    DamageReportController_2.changeStatus(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "changeStatus",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """ChangeStatus/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_DamageReportController_createImage2_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Image")))
  )
  private[this] lazy val controllers_DamageReportController_createImage2_invoker = createInvoker(
    DamageReportController_2.createImage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "createImage",
      Nil,
      "PUT",
      this.prefix + """Image""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_DamageReportController_getImage3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Image/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DamageReportController_getImage3_invoker = createInvoker(
    DamageReportController_2.getImage(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "getImage",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """Image/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_DamageReportController_createEvent4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Event")))
  )
  private[this] lazy val controllers_DamageReportController_createEvent4_invoker = createInvoker(
    DamageReportController_2.createEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "createEvent",
      Nil,
      "PUT",
      this.prefix + """Event""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_DamageReportController_getEvent5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Event/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DamageReportController_getEvent5_invoker = createInvoker(
    DamageReportController_2.getEvent(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "getEvent",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """Event/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_DamageReportController_createDamageReport6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("DamageReport")))
  )
  private[this] lazy val controllers_DamageReportController_createDamageReport6_invoker = createInvoker(
    DamageReportController_2.createDamageReport(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "createDamageReport",
      Nil,
      "PUT",
      this.prefix + """DamageReport""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_DamageReportController_updateDamageReport7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("DamageReport")))
  )
  private[this] lazy val controllers_DamageReportController_updateDamageReport7_invoker = createInvoker(
    DamageReportController_2.updateDamageReport(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "updateDamageReport",
      Nil,
      "POST",
      this.prefix + """DamageReport""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_DamageReportController_getDamageReport8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("DamageReport/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DamageReportController_getDamageReport8_invoker = createInvoker(
    DamageReportController_2.getDamageReport(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "getDamageReport",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """DamageReport/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_DamageReportController_getDamageReports9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("DamageReport")))
  )
  private[this] lazy val controllers_DamageReportController_getDamageReports9_invoker = createInvoker(
    DamageReportController_2.getDamageReports(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DamageReportController",
      "getDamageReports",
      Nil,
      "GET",
      this.prefix + """DamageReport""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_MailGrabber_newMail10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("email")))
  )
  private[this] lazy val controllers_MailGrabber_newMail10_invoker = createInvoker(
    MailGrabber_1.newMail(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MailGrabber",
      "newMail",
      Nil,
      "POST",
      this.prefix + """email""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:11
    case controllers_DamageReportController_changeStatus1_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DamageReportController_changeStatus1_invoker.call(DamageReportController_2.changeStatus(id))
      }
  
    // @LINE:13
    case controllers_DamageReportController_createImage2_route(params@_) =>
      call { 
        controllers_DamageReportController_createImage2_invoker.call(DamageReportController_2.createImage())
      }
  
    // @LINE:14
    case controllers_DamageReportController_getImage3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DamageReportController_getImage3_invoker.call(DamageReportController_2.getImage(id))
      }
  
    // @LINE:16
    case controllers_DamageReportController_createEvent4_route(params@_) =>
      call { 
        controllers_DamageReportController_createEvent4_invoker.call(DamageReportController_2.createEvent())
      }
  
    // @LINE:17
    case controllers_DamageReportController_getEvent5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DamageReportController_getEvent5_invoker.call(DamageReportController_2.getEvent(id))
      }
  
    // @LINE:19
    case controllers_DamageReportController_createDamageReport6_route(params@_) =>
      call { 
        controllers_DamageReportController_createDamageReport6_invoker.call(DamageReportController_2.createDamageReport())
      }
  
    // @LINE:20
    case controllers_DamageReportController_updateDamageReport7_route(params@_) =>
      call { 
        controllers_DamageReportController_updateDamageReport7_invoker.call(DamageReportController_2.updateDamageReport())
      }
  
    // @LINE:21
    case controllers_DamageReportController_getDamageReport8_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DamageReportController_getDamageReport8_invoker.call(DamageReportController_2.getDamageReport(id))
      }
  
    // @LINE:22
    case controllers_DamageReportController_getDamageReports9_route(params@_) =>
      call { 
        controllers_DamageReportController_getDamageReports9_invoker.call(DamageReportController_2.getDamageReports())
      }
  
    // @LINE:24
    case controllers_MailGrabber_newMail10_route(params@_) =>
      call { 
        controllers_MailGrabber_newMail10_invoker.call(MailGrabber_1.newMail())
      }
  }
}
