package controllers

import javax.inject._
import play.api._

import play.modules.reactivemongo._
import play.api.mvc.{ Action, Controller }
import reactivemongo.bson.BSONObjectID

import services.AddList
//import scala.collection.mutable._



/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an list[Int] to User. 
 */
@Singleton
class AddListController @Inject() (add:AddList)(val reactiveMongoApi: ReactiveMongoApi) extends Controller with MongoController with ReactiveMongoComponents  {

  /**
   * Create an action that responds with the GetList  list[Int].
   * The result is List[Int]. This `Action` is mapped to
   * `GET /get` requests by an entry in the `routes` config file.
   */
  def add_List = Action {
    var v= foo
    println(s"Foo: ${v.stringify}")
    Ok(views.html.add(add.addList(5,100) , v.stringify))
   
  }

   def foo : BSONObjectID= {
    var id = BSONObjectID.generate
    id
  }
 

}


