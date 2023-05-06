package Basics

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val a :String = "Kapil Kumar"
    println(a.isInstanceOf[String])
    println(a.isInstanceOf[Int])
  }
}
