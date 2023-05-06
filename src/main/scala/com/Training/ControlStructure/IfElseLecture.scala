package ControlStructure

// In Scala, we can return things from control-statements like if-else-then/for etc

object IfElseLecture {
  def main(args: Array[String]): Unit = {
    val name = if (1 == 0) "Bangalore" else "Hyderabad"
    println(name)

    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val new_list = if(name == "Bangalore")
      list.map{x=>x*10}
    else
      list.map{x=>x*20}

    println(new_list)
  }
}
