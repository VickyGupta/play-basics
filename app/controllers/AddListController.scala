package controllers

import javax.inject._
import play.api._


import scala.concurrent.Future

import play.api.libs.concurrent.Execution.Implicits.defaultContext

import play.modules.reactivemongo._
import play.api.mvc.{ Action, Controller }
import reactivemongo.bson.BSONObjectID
import play.api.libs.json._
import play.api.libs.json.Json._



// Reactive Mongo imports
import reactivemongo.api.Cursor




// BSON-JSON conversions/collection
import reactivemongo.play.json._
import play.modules.reactivemongo.json.collection._

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

  def collection: JSONCollection = db.collection[JSONCollection]("sample")



 
  def add_List1 = Action {
   
    var v= foo
    
    println(s"Foo: ${v.stringify}")
    Ok(views.html.add(add.addList(5,100) , v.stringify))
   
  }

   def create {
     println("enter")
    val json = Json.obj(
      "name" -> "Vicky",
      "age" -> 27,
      "created" -> new java.util.Date().getTime())

      collection.insert(json).onComplete { lastError =>
        Logger.debug(s"Successfully inserted with LastError: $lastError")
        Created
      }

      

    // collection.insert(json).map(lastError =>
    //   Ok("Mongo LastError: %s".format(lastError)))
  }


   def add_List = Action.async {
        val cursor: Cursor[JsObject] = collection.find(Json.obj("name" -> "Vicky")).cursor[JsObject]

	        val futureSampleList: Future[List[JsObject]] = cursor.collect[List]()
	                
	        futureSampleList.map { sample =>
	            Ok(toJson(Map("result" -> toJson("success"),"sample" -> toJson(sample))))
	        }
   }


   def foo : BSONObjectID= {
    var id = BSONObjectID.generate
    id
  }
 

}


