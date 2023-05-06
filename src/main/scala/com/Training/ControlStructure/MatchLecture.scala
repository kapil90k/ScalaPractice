package ControlStructure

object MatchLecture {
  def main(args: Array[String]): Unit = {
    val city = "Bangalore"

    //    Usage 1
    city match {
      case "Bangalore" => println("Karnataka")
      case "Hyderabad" | "Nellore" => println("Andhra Pradesh")
      case "Chennai"  => println("Tamil Nadu")
      case _ => println("Jammu & Kashmir")
    }

    //    Usage 2
    val exception = new NullPointerException
    exception match {
      case e: ArithmeticException => println(e)
      case e: NullPointerException => println(e)
      case _ => println("Exception not found")
    }

    //    Usage 3
    val list = List("Kapil", 10, 10.2F, 30L,List("Singh",20))
    val new_list = list.map { x =>
      x match {
        case e: String => "String"
        case e: Int => "Integer"
        case e: Float => "Float"
        case e: Long => "Long"
        case e: List[Any] => s"This is list of ${e.size} elements with first element as ${e(0)}"
        case _ => "Null"
      }
    }
    new_list.foreach(println)

  }
}
