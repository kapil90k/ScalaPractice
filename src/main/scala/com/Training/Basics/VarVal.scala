package Basics

object VarVal extends App{
  var a = 10
  val b = 20
  println("Value of a: "+a)
  println("Value of b: "+b)

  a = 12
//  b = 22 val can't be updated
  println("Updated value of a: "+ a)

}
