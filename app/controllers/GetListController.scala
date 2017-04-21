package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import services.GetList
//import scala.collection.mutable._



/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an list[Int] to User. 
 */
@Singleton
class GetListController @Inject() (g:GetList) extends Controller {

  /**
   * Create an action that responds with the GetList  list[Int].
   * The result is List[Int]. This `Action` is mapped to
   * `GET /get` requests by an entry in the `routes` config file.
   */
  def get_List = Action { Ok(g.getList().toString())}

}
