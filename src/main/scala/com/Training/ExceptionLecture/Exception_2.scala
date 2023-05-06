package ExceptionLecture

import scala.util.{Failure, Success, Try}

object Exception_2 extends App {
  val prob_1 = Try(
    if(1==1)
      "Kapil".toInt
    else
      "150".toInt
  )
//  println(prob_1.getOrElse(100))
  prob_1 match {
    case Success(v) => println(s"Casted, value is ${prob_1.get}")
    case Failure(e) => println(s"Failed, default is ${prob_1.getOrElse(100)}")
  }

}
