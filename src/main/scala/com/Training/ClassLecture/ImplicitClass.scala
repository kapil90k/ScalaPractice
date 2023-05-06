package ClassLecture

//https://stackoverflow.com/questions/32286628/difference-between-conversion-with-implicit-function-and-implicit-class-in-scala

object ImplicitClass {

  implicit class StringImprovement(val s: String) {
    def increment(): String = s.map { x =>
      (x + 1).toChar
    }

    def decrement(): String = s.map { x =>
      (x - 1).toChar
    }

    def hideAll(): String = s.replaceAll(" ", "**")
  }

  def main(args: Array[String]): Unit = {
    val name = "HAL HAL"
    println("Original: " + name)
    println("Incremental: " + name.increment())
    println("Decremental: " + name.decrement())
    println("Hiding Spaces: " + name.hideAll())
  }
}