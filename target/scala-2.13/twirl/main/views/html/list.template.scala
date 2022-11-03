
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
/*1.2*/import models.responses.CommonListResponse

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[CommonListResponse[Software],List[Software],String,String,String,Http.Request,play.i18n.Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(pageList: CommonListResponse[Software],
        itemList: List[Software],
        currentSortBy: String,
        currentOrder: String,
        currentFilter: String)(
        implicit request: Http.Request,
        messages: play.i18n.Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*40.6*/header/*40.12*/(key:String, title:String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*40.42*/("""
        """),format.raw/*41.9*/("""<th scope="col" class=""""),_display_(/*41.33*/key/*41.36*/.replace(".","_")),format.raw/*41.53*/("""">
            <a class="sort-link """),_display_(/*42.34*/if(currentSortBy != key)/*42.58*/ {_display_(Seq[Any](format.raw/*42.60*/(""" """),format.raw/*42.61*/("""sort-link-inactive """)))}),format.raw/*42.81*/("""" href=""""),_display_(/*42.90*/link(0, key)),format.raw/*42.102*/("""">"""),_display_(/*42.105*/title),format.raw/*42.110*/(""" """),_display_(/*42.112*/sortIcon(key)),format.raw/*42.125*/("""</a>
        </th>
    """)))};def /*47.6*/sortIcon/*47.14*/(key:String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*47.30*/("""
    """),_display_(/*48.6*/if(currentOrder == "asc")/*48.31*/ {_display_(Seq[Any](format.raw/*48.33*/("""
        """),format.raw/*49.9*/("""<i class="fa fa-fw fa-caret-down"></i>
    """)))}/*50.7*/else/*50.12*/{_display_(Seq[Any](format.raw/*50.13*/("""
        """),format.raw/*51.9*/("""<i class="fa fa-fw fa-caret-up"></i>
    """)))}),format.raw/*52.6*/("""

    """)))};def /*14.6*/link/*14.10*/(newPage:Int, newSortBy:String) = {{

        var sortBy = currentSortBy
        var order = currentOrder

        if(newSortBy != null) {
            sortBy = newSortBy
            if(currentSortBy == newSortBy) {
                if(currentOrder == "asc") {
                    order = "desc"
                } else {
                    order = "asc"
                }
            } else {
                order = "asc"
            }
        }

        // Generate the link
        routes.HomeController.list(newPage, sortBy, order, currentFilter)

    }};
Seq[Any](format.raw/*10.1*/("""
    """),format.raw/*13.46*/("""
    """),format.raw/*35.6*/("""

        """),format.raw/*39.45*/("""
    """),format.raw/*44.6*/("""


    """),format.raw/*54.6*/("""

    """),_display_(/*56.6*/main/*56.10*/ {_display_(Seq[Any](format.raw/*56.12*/("""

        """),format.raw/*58.9*/("""<h1 class="my-3" id="page-title">"""),_display_(/*58.43*/Messages("software.list.title", pageList.getTotalCount)),format.raw/*58.98*/("""</h1>

        """),_display_(/*60.10*/request/*60.17*/.flash.asScala().get("success").map/*60.52*/ { successFlashValue =>_display_(Seq[Any](format.raw/*60.75*/("""
            """),format.raw/*61.13*/("""<div class="alert alert-success" role="alert">
                <strong>Done!</strong> """),_display_(/*62.41*/successFlashValue),format.raw/*62.58*/("""
            """),format.raw/*63.13*/("""</div>
        """)))}),format.raw/*64.10*/("""

        """),_display_(/*66.10*/request/*66.17*/.flash.asScala().get("fail").map/*66.49*/ { failFlashValue =>_display_(Seq[Any](format.raw/*66.69*/("""
            """),format.raw/*67.13*/("""<div class="alert alert-danger" role="alert">
                <strong>FAIL!</strong> """),_display_(/*68.41*/failFlashValue),format.raw/*68.55*/("""
            """),format.raw/*69.13*/("""</div>
        """)))}),format.raw/*70.10*/("""

        """),format.raw/*72.9*/("""<div class="row">
            <div class="col-sm-6">
                <form class="form-inline" action=""""),_display_(/*74.52*/link(0, "name")),format.raw/*74.67*/("""" method="GET">
                    <div class="form-group mr-sm-2 mb-2">
                        <label for="searchbox" class="sr-only">Filter by software name...</label>
                        <input type="search" class="form-control" id="searchbox" name="f" value=""""),_display_(/*77.99*/currentFilter),format.raw/*77.112*/("""" placeholder="Filter by software name...">
                    </div>
                    <button type="submit" id="searchsubmit" class="btn btn-primary mb-2">Filter by name</button>
                </form>
            </div>
            <div class="col-sm-6">
                <a href=""""),_display_(/*83.27*/routes/*83.33*/.HomeController.create()),format.raw/*83.57*/("""" id="add" class="btn btn-success float-right" role="button"1>Add a new software</a>
            </div>
        </div>

        """),_display_(/*87.10*/if(pageList.getTotalCount == 0)/*87.41*/ {_display_(Seq[Any](format.raw/*87.43*/("""

            """),format.raw/*89.13*/("""<div class="card card-body bg-light">
                <em>Nothing to display</em>
            </div>

        """)))}/*93.11*/else/*93.16*/{_display_(Seq[Any](format.raw/*93.17*/("""

            """),format.raw/*95.13*/("""<table class="table table-bordered table-striped table-hover">
                <thead class="thead-light">
                    <tr>
                        """),_display_(/*98.26*/header("name", "Software name")),format.raw/*98.57*/("""
                        """),_display_(/*99.26*/header("introduced", "Introduced")),format.raw/*99.60*/("""
                        """),_display_(/*100.26*/header("discontinued", "Discontinued")),format.raw/*100.64*/("""
                        """),_display_(/*101.26*/header("company.name", "Company")),format.raw/*101.59*/("""
                    """),format.raw/*102.21*/("""</tr>
                </thead>
                <tbody>

                """),_display_(/*106.18*/for(software <- itemList) yield /*106.43*/ {_display_(Seq[Any](format.raw/*106.45*/("""
                    """),format.raw/*107.21*/("""<tr>
                        <td><a href=""""),_display_(/*108.39*/routes/*108.45*/.HomeController.edit(software.getId())),format.raw/*108.83*/("""">"""),_display_(/*108.86*/software/*108.94*/.getName()),format.raw/*108.104*/("""</a></td>
                        <td>
                        """),_display_(/*110.26*/if(software.getIntroduced() == null)/*110.62*/ {_display_(Seq[Any](format.raw/*110.64*/("""
                            """),format.raw/*111.29*/("""<em>-</em>
                        """)))}/*112.27*/else/*112.32*/{_display_(Seq[Any](format.raw/*112.33*/("""
                            """),_display_(/*113.30*/software/*113.38*/.getIntroduced().format("dd MMM yyyy")),format.raw/*113.76*/("""
                        """)))}),format.raw/*114.26*/("""
                        """),format.raw/*115.25*/("""</td>
                        <td>
                        """),_display_(/*117.26*/if(software.getDiscontinued() == null)/*117.64*/ {_display_(Seq[Any](format.raw/*117.66*/("""
                            """),format.raw/*118.29*/("""<em>-</em>
                        """)))}/*119.27*/else/*119.32*/{_display_(Seq[Any](format.raw/*119.33*/("""
                            """),_display_(/*120.30*/software/*120.38*/.getDiscontinued().format("dd MMM yyyy")),format.raw/*120.78*/("""
                        """)))}),format.raw/*121.26*/("""
                        """),format.raw/*122.25*/("""</td>
                        <td>
                        """),_display_(/*124.26*/if(software.getCompany() == null)/*124.59*/ {_display_(Seq[Any](format.raw/*124.61*/("""
                            """),format.raw/*125.29*/("""<em>-</em>
                        """)))}/*126.27*/else/*126.32*/{_display_(Seq[Any](format.raw/*126.33*/("""
                            """),_display_(/*127.30*/software/*127.38*/.getCompany().getName()),format.raw/*127.61*/("""
                        """)))}),format.raw/*128.26*/("""
                        """),format.raw/*129.25*/("""</td>
                    </tr>
                """)))}),format.raw/*131.18*/("""

                """),format.raw/*133.17*/("""</tbody>
            </table>

            <nav aria-label="...">
                <ul class="pagination float-right">
                    """),_display_(/*138.22*/if(pageList.getHasPrev)/*138.45*/ {_display_(Seq[Any](format.raw/*138.47*/("""
                        """),format.raw/*139.25*/("""<li class="page-item previous">
                            <a class="page-link" href=""""),_display_(/*140.57*/link(pageList.getPage - 1, null)),format.raw/*140.89*/("""">&larr; Previous</a>
                        </li>
                    """)))}/*142.23*/else/*142.28*/{_display_(Seq[Any](format.raw/*142.29*/("""
                        """),format.raw/*143.25*/("""<li class="page-item previous disabled">
                            <a class="page-link">&larr; Previous</a>
                        </li>
                    """)))}),format.raw/*146.22*/("""
                    """),format.raw/*147.21*/("""<li class="page-item disabled" aria-current="page">
                        <a class="page-link" href="#">Displaying """),_display_(/*148.67*/pageList/*148.75*/.getFromXtoY()),format.raw/*148.89*/("""</a>
                    </li>
                    """),_display_(/*150.22*/if(pageList.getHasNext)/*150.45*/ {_display_(Seq[Any](format.raw/*150.47*/("""
                        """),format.raw/*151.25*/("""<li class="page-item next">
                            <a class="page-link" href=""""),_display_(/*152.57*/link(pageList.getPage + 1, null)),format.raw/*152.89*/("""">Next &rarr;</a>
                        </li>
                    """)))}/*154.23*/else/*154.28*/{_display_(Seq[Any](format.raw/*154.29*/("""
                        """),format.raw/*155.25*/("""<li class="page-item next disabled">
                            <a class="page-link" >Next &rarr;</a>
                        </li>
                    """)))}),format.raw/*158.22*/("""
                """),format.raw/*159.17*/("""</ul>
            </nav>

        """)))}),format.raw/*162.10*/("""
    """)))}),format.raw/*163.6*/("""
"""))
      }
    }
  }

  def render(pageList:CommonListResponse[Software],itemList:List[Software],currentSortBy:String,currentOrder:String,currentFilter:String,request:Http.Request,messages:play.i18n.Messages): play.twirl.api.HtmlFormat.Appendable = apply(pageList,itemList,currentSortBy,currentOrder,currentFilter)(request,messages)

  def f:((CommonListResponse[Software],List[Software],String,String,String) => (Http.Request,play.i18n.Messages) => play.twirl.api.HtmlFormat.Appendable) = (pageList,itemList,currentSortBy,currentOrder,currentFilter) => (request,messages) => apply(pageList,itemList,currentSortBy,currentOrder,currentFilter)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/list.scala.html
                  HASH: 8b636a20e31cae253232b518ba245370b8e33ffd
                  MATRIX: 610->1|1046->46|1370->1136|1385->1142|1492->1172|1528->1181|1579->1205|1591->1208|1629->1225|1692->1261|1725->1285|1765->1287|1794->1288|1845->1308|1881->1317|1915->1329|1946->1332|1973->1337|2003->1339|2038->1352|2085->1384|2102->1392|2195->1408|2227->1414|2261->1439|2301->1441|2337->1450|2399->1495|2412->1500|2451->1501|2487->1510|2559->1552|2589->436|2602->440|3188->292|3221->430|3253->996|3291->1130|3323->1376|3357->1559|3390->1566|3403->1570|3443->1572|3480->1582|3541->1616|3617->1671|3660->1687|3676->1694|3720->1729|3781->1752|3822->1765|3936->1852|3974->1869|4015->1882|4062->1898|4100->1909|4116->1916|4157->1948|4215->1968|4256->1981|4369->2067|4404->2081|4445->2094|4492->2110|4529->2120|4660->2224|4696->2239|4993->2509|5028->2522|5343->2810|5358->2816|5403->2840|5559->2969|5599->3000|5639->3002|5681->3016|5811->3128|5824->3133|5863->3134|5905->3148|6089->3305|6141->3336|6194->3362|6249->3396|6303->3422|6363->3460|6417->3486|6472->3519|6522->3540|6623->3613|6665->3638|6706->3640|6756->3661|6827->3704|6843->3710|6903->3748|6934->3751|6952->3759|6985->3769|7077->3833|7123->3869|7164->3871|7222->3900|7278->3937|7292->3942|7332->3943|7390->3973|7408->3981|7468->4019|7526->4045|7580->4070|7668->4130|7716->4168|7757->4170|7815->4199|7871->4236|7885->4241|7925->4242|7983->4272|8001->4280|8063->4320|8121->4346|8175->4371|8263->4431|8306->4464|8347->4466|8405->4495|8461->4532|8475->4537|8515->4538|8573->4568|8591->4576|8636->4599|8694->4625|8748->4650|8829->4699|8876->4717|9043->4856|9076->4879|9117->4881|9171->4906|9287->4994|9341->5026|9434->5100|9448->5105|9488->5106|9542->5131|9735->5292|9785->5313|9931->5431|9949->5439|9985->5453|10065->5505|10098->5528|10139->5530|10193->5555|10305->5639|10359->5671|10448->5741|10462->5746|10502->5747|10556->5772|10742->5926|10788->5943|10855->5978|10892->5984
                  LINES: 23->1|28->3|38->40|38->40|40->40|41->41|41->41|41->41|41->41|42->42|42->42|42->42|42->42|42->42|42->42|42->42|42->42|42->42|42->42|42->42|44->47|44->47|46->47|47->48|47->48|47->48|48->49|49->50|49->50|49->50|50->51|51->52|53->14|53->14|75->10|76->13|77->35|79->39|80->44|83->54|85->56|85->56|85->56|87->58|87->58|87->58|89->60|89->60|89->60|89->60|90->61|91->62|91->62|92->63|93->64|95->66|95->66|95->66|95->66|96->67|97->68|97->68|98->69|99->70|101->72|103->74|103->74|106->77|106->77|112->83|112->83|112->83|116->87|116->87|116->87|118->89|122->93|122->93|122->93|124->95|127->98|127->98|128->99|128->99|129->100|129->100|130->101|130->101|131->102|135->106|135->106|135->106|136->107|137->108|137->108|137->108|137->108|137->108|137->108|139->110|139->110|139->110|140->111|141->112|141->112|141->112|142->113|142->113|142->113|143->114|144->115|146->117|146->117|146->117|147->118|148->119|148->119|148->119|149->120|149->120|149->120|150->121|151->122|153->124|153->124|153->124|154->125|155->126|155->126|155->126|156->127|156->127|156->127|157->128|158->129|160->131|162->133|167->138|167->138|167->138|168->139|169->140|169->140|171->142|171->142|171->142|172->143|175->146|176->147|177->148|177->148|177->148|179->150|179->150|179->150|180->151|181->152|181->152|183->154|183->154|183->154|184->155|187->158|188->159|191->162|192->163
                  -- GENERATED --
              */
          