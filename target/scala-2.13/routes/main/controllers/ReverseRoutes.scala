// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers {

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def delete(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "softwares/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)) + "/delete")
    }
  
    // @LINE:5
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "softwares")
    }
  
    // @LINE:3
    def list(p:Int = 0, s:String = "name", o:String = "asc", f:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "softwares" + play.core.routing.queryString(List(if(p == 0) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("p", p)), if(s == "name") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("f", f)))))
    }
  
    // @LINE:7
    def update(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "softwares/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:4
    def create(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "softwares/new")
    }
  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:6
    def edit(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "softwares/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
