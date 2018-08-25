// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/RSQLAPTOP/Documents/GVBChallenge/backend/conf/routes
// @DATE:Sat Aug 25 19:14:27 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
