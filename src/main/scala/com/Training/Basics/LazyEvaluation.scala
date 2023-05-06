package Basics

class Strict{
  val s: Int ={
    println("Strict")
    9
  }
  lazy val l: Int ={
    println("Lazy")
    10
  }
}

object LazyEvaluation {
  def main(args: Array[String]): Unit = {
  val obj = new Strict
    println(obj.s)
    println(obj.l)
  }
}
