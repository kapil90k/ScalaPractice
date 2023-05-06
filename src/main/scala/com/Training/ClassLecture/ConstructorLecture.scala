package ClassLecture

class Person(name: String, age: Int) {
  def this(name: String) = this(name, 26)

  def this() = this("Kapil Kumar", 25)

  override def toString = s"$name is $age years old"
}

object DefaultConstructor {
  def main(args: Array[String]): Unit = {
  println(new Person())                 // No parameter
  println(new Person("Shubham Singh"))  // 1 parameter
  println(new Person("Sonu Singh", 30)) // All variables
  }
}
