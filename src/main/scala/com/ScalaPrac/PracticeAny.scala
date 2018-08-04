package com.ScalaPrac

import scala.collection.mutable


object PracticeAny
{
  case class Vehicle(name:String,manufacturing:String)
  case class Engine(strength:String,build:String)

  def main(args: Array[String]): Unit = {
    val vehicle = Vehicle("Honda","2016")
    val engine  = Engine("Very Powerfull","Fresh")
    val mutMap = mutable.Map.empty[String,Any]
    mutMap += ("String"->"This is String","double"->2.4,"vehicle" -> vehicle,"engine"->engine)
    val immutableMap=mutMap.toMap

    immutableMap.foreach{
      case(k,v) =>{
        v match {
          case x:String => println(x)
          case x:Double => println(x)
          case x:Vehicle => println(x.name)
          case x:Engine => println(x.build)
        }
      }
    }

  }
}
