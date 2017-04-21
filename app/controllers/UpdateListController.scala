package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import services.UpdateList
//import scala.collection.mutable._

import play.api.libs.json._



/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an list[Int] to User. 
 */
@Singleton
class UpdateListController @Inject() (up:UpdateList) extends Controller {

  /**
   * Create an action that responds with the GetList  list[Int].
   * The result is List[Int]. This `Action` is mapped to
   * `GET /get` requests by an entry in the `routes` config file.
   */
  def update_List = Action { 
     Ok(views.html.getJson(Json.obj("result" -> "success", "message"-> "successfully", "error"->"1123",  "data" -> up.updateList(6,10))))
      //Ok(views.html.getJson("Your new application is ready."))

      //Ok(up.updateList(5,100).toString())

      //Ok(Json.obj("result" -> "success", "message"-> "successfully", "error"->"1123",  "data" -> up.updateList(6,10)))
      

   }

  
}
