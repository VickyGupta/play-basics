package services

import java.util.concurrent.atomic.AtomicInteger
import javax.inject._
///import scala.collection.mutable._

import services.GetList
 //import scala.collection.mutable.Buffer




/**
 * This trait demonstrates how to create a component that is injected
 * into a controller. The trait represents a TraitGetList  that returns a
 * List[Int]
 */
trait TraitDeleteList {
  def deleteList(value:Int):List[Int]
}

/**
 * This class is a concrete implementation of the [[TraitGetList]] trait.
 * It is configured for Guice dependency injection in the [[Module]]
 * class.
 *
 * This class has a `Singleton` annotation because we need to make
 * sure we only use one counter per application. Without this
 * annotation we would get a new instance every time a [[TraitGetList]] is
 * injected.
 */
 
@Singleton
class DeleteList @Inject() (g:GetList) extends TraitDeleteList {  
 
  override def deleteList(value:Int)={
      var i:Int=0;
      var list=g.getList()
      
      var lb=list.toBuffer
      lb-=value
    
    lb.toList
  }

}
