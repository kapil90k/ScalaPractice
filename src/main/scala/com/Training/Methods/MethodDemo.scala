package Methods

object MethodDemo {
  def main(args: Array[String]): Unit = {
    method_noreturn()

    val list = method_return(10)
    println(list)

    method_default_argument("Kapil")

  }

  def method_noreturn():Unit={
    val ret_value = "Printing inside method_noargs() method"
    println(ret_value)
  }

  def method_return(num:Int): List[Int]={
    val list = for(i <- 0 until num) yield
      i
    list.toList
  }

  def method_default_argument(name: String, age:Int = 20): Unit={
    println("My name is "+ name +" and age is " +age)
  }
}
