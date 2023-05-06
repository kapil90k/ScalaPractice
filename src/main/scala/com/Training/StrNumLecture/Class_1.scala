package StrNumLecture

object Class_1 extends App{
  val str = "Hello World"
  println(str)
  println(str.getClass.getSimpleName)
  println(str.length)
  println(str+", this is Kapil")
  println(str.filter(_ != 'o'))
  println("KabirSingh".drop(4))
  println("kabirSingh".take(4).capitalize)
}
