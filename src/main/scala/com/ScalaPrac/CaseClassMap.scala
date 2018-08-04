package com.ScalaPrac

import scala.reflect.ClassTag
/**
  * This class can convert any case class to Scala Map.
  * */

case class Vehicle(wheels:Int,company:String,model:String,id:Int)
case class Engine(id:Int,name:String,year:String,company:String)
object CaseClassMap
{
  def main(args: Array[String]): Unit = {
    val vehicle1 = Vehicle(1000,"Honda","XT-1000",2)
    val engine = Engine(1000,"XT-2000","03072019","Honda")
    /*vehicle1.getClass.getDeclaredFields.map{
      x=>x.getName
    }.foreach(println)


    val fields=vehicle1.getClass.getDeclaredFields
    var caseMap=mutable.Map[String,Any]()
    fields.foreach{x=>
      x.setAccessible(true)
      val value = Map(x.getName -> x.get(vehicle1))
      caseMap ++= value
    }
    println("Printing Map--->")
    caseMap.foreach(println(_))
    println("**************Map printed**************")*/
    val vehicle1Map=caseClassToMap2[Vehicle](vehicle1)
    val engineMap = caseClassToMap2(engine)
    vehicle1Map.foreach(println)
    engineMap.foreach(println)
  }

  def caseClassToMap[C](c: C)(implicit classTag: ClassTag[C]): Map[String, Any] = {
    val fields = (Map[String, Any]() /: c.getClass.getDeclaredFields) { (acc, f) =>
      f.setAccessible(true)
      acc + (f.getName -> f.get(c))
    }
    fields - "$outer"
  }

  def caseClassToMap2[C](c: C): Map[String, Any] = {
    val fields = c.getClass.getDeclaredFields
    val map=fields.foldLeft(Map[String, Any]()){ (acc, f) =>
      f.setAccessible(true)
      acc + (f.getName -> f.get(c))
    }
    map
  }

}
