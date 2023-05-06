package ImpLecture

object OptionLecture {
  def main(args: Array[String]): Unit = {
    val state = find_state("Bangalore")
    println(state.isDefined)
    println(state.isEmpty)
    println(state.getOrElse("Not Found"))
  }

  def find_state(city: String): Option[String] = {
    val state = city match {
      case "Bangalore" => Some("Karnataka")
      case "Chennai" => Some("Tamilnadu")
      case "Allepy" => Some("Kerala")
      case _ => None
    }
    state
  }
}

