package ImpLecture

object TupleLecture {

  case class Employee(name: String, city: String, age: Int){
    override def toString: String = s"$name is $age year old and lives in $city"
  }

  def main(args: Array[String]): Unit = {
    val mix_tuple = ("Kapil Kumar", "Agra", 25)
    println(mix_tuple._1)
    println(mix_tuple._2)
    println(mix_tuple._3)
    val list = List("Kapil", "India")
    val tup_ret = return_tuple(list)
    println("\n\nPrinting tuple returned from method===>")
    println(tup_ret._1, tup_ret._1.getClass)
    println(tup_ret._2, tup_ret._2.getClass)
    println(tup_ret._3, tup_ret._3.getClass)
    println(tup_ret._4, tup_ret._4.getClass)
  }

  def return_tuple(list: List[String]): (String, String, Int, Employee) = {
    val emp = Employee("Sonu Singh", "Bangalore", 28)
    (list(0), list(1), list(1).size, emp)
  }
}
