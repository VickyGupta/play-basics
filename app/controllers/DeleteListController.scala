package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import services.DeleteList
//import scala.collection.mutable._

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an list[Int] to User. 
 */
@Singleton
class DeleteListController @Inject() (del:DeleteList) extends Controller {

  /**
   * Create an action that responds with the GetList  list[Int].
   * The result is List[Int]. This `Action` is mapped to
   * `GET /get` requests by an entry in the `routes` config file.
   */
  def delete_List = Action { Ok(del.deleteList(5).toString() )}

}
