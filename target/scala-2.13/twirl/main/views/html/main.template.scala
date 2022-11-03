
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Software products database</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*9.66*/routes/*9.72*/.Assets.at("stylesheets/bootstrap/bootstrap.min.css")),format.raw/*9.125*/("""">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <link rel="stylesheet" media="screen" href=""""),_display_(/*12.50*/routes/*12.56*/.Assets.at("stylesheets/main.css")),format.raw/*12.90*/(""""/>
    <link rel="icon" type="image/x-icon" href=""""),_display_(/*13.49*/routes/*13.55*/.Assets.at("/images/favicon.ico")),format.raw/*13.88*/("""">
  </head>
  <body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
      <a class="navbar-brand" href=""""),_display_(/*18.38*/routes/*18.44*/.HomeController.index()),format.raw/*18.67*/("""">
        <img class="mr-4" src=""""),_display_(/*19.33*/routes/*19.39*/.Assets.at("/images/software.png")),format.raw/*19.73*/("""" alt="icon"  style="height: 50px"/>
        <span>SOFTWARE PRODUCTS</span>
      </a>
    </nav>

    <main role="main" class="container-fluid">
    """),_display_(/*25.6*/content),format.raw/*25.13*/("""
    """),format.raw/*26.5*/("""</main>

  </body>
</html>
"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: 9f6022cc5ab947864ae562f4eea4f17b4d5ada7e
                  MATRIX: 904->1|1013->17|1040->18|1327->279|1341->285|1415->338|1600->496|1615->502|1670->536|1749->588|1764->594|1818->627|1967->749|1982->755|2026->778|2088->813|2103->819|2158->853|2335->1004|2363->1011|2395->1016
                  LINES: 27->1|32->2|33->3|39->9|39->9|39->9|42->12|42->12|42->12|43->13|43->13|43->13|48->18|48->18|48->18|49->19|49->19|49->19|55->25|55->25|56->26
                  -- GENERATED --
              */
          