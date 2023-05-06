package ImpLecture

import scala.collection.mutable.ListBuffer

object EitherLecture {
  def main(args: Array[String]): Unit = {
    val list = (1 to 10).toList
    val finder = find_even_odd(10)
    finder match {
      case Left(left)=> println(s"Printing size of returned list: ${left.size}")
      case Right(what) => println(s"Got this message: $what")
    }
  }
  def find_even_odd(num:Int):Either[List[Int],String]={
    if(num % 2 == 0)
      Left(List(10,20,30,40))
    else Right("Not Even")
  }
}
