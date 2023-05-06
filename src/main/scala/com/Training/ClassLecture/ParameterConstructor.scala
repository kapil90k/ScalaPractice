package ClassLecture

class Person1(var firstName: String, var lastName: String) {
  println("the constructor begins")
  private val HOME = System.getProperty("user.home")
  var age = 0

  override def toString = s"$firstName $lastName is $age years old"

  def printHome(): Unit = {
    println(s"HOME = $HOME")
  }

  def printFullName(): Unit = {
    println(this)
  } // uses toString
  printHome()
  printFullName()
  println("still in the constructor")
}

object ParameterConstructor {
  def main(args: Array[String]): Unit = {
    val person = new Person1("Adam","Meyer")
  }
}

