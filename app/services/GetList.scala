package services

import java.util.concurrent.atomic.AtomicInteger
import javax.inject._
///import scala.collection.mutable._



/**
 * This trait demonstrates how to create a component that is injected
 * into a controller. The trait represents a TraitGetList  that returns a
 * List[Int]
 */
trait TraitGetList {
  def getList():List[Int]
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
class GetList extends TraitGetList {  
 
  override def getList()={
    var list=List.range(1 , 10)
    list
  }
}
