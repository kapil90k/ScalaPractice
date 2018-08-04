package com.ScalaPrac

object GenericPractice1
{
  case class Vehicle(name:String,manufacturing:String)
  case class Engine(strength:String,build:String)

  def main(args: Array[String]): Unit = {
    genericPrint[String]("This is String")
    genericPrint[Int](2)
    genericPrint[Vehicle](Vehicle("Honda","2016"))
    genericPrint[Engine](Engine("Very Powerfull","Fresh"))
  }

  def genericPrint[T](varialble :T): Unit ={
  val className = varialble.getClass.getSimpleName
    className match {
      case "String"=>{
        val str=varialble.asInstanceOf[String]
        println("Printing String===>  "+str)
      }
      case "Integer"=>{
        val myInt=varialble.asInstanceOf[Integer]
        println("Printing Integer===>  "+myInt)
      }
      case "Vehicle"=>{
        val vehicle = varialble.asInstanceOf[Vehicle]
        println("Printing Vehicle===>  "+vehicle.name+ " - "+vehicle.manufacturing)
      }
      case "Engine"=>{
        val engine = varialble.asInstanceOf[Engine]
        println("Printing Engine===>  "+engine.build+" - "+engine.strength)
      }
//      case myInt:Int => print(myInt)
    }
  }
}
