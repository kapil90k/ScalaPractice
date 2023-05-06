package Methods

class Employee(name: String, age: Int, city: String) {
  override def toString: String = s"$name lives in $city and his age is $age"

  override def equals(that: Any): Boolean = {
    println("Inside custom equals() method")
    if (this.hashCode().equals(that.hashCode()))
      true
    else false
  }

  override def hashCode(): Int = {
    println("Inside custom hashcode() method")
    this.name.hashCode() + this.age.hashCode() + this.city.hashCode
  }
}

object EqualsOverriding {
  def main(args: Array[String]): Unit = {
    val name1 = "Kapil"
    val name2 = "Ka" + "pil"
    println(name1 == name2)

    val emp1 = new Employee("Kapil", 25, "Bangalore")
    val emp2 = new Employee("Kapil", 25, "Bangalore")
    val emp3 = new Employee("Sonu", 26, "Agra")
    println("Employee 1===>  ",emp1)
    println("Employee 2===>  ",emp2)
    println("Employee 3===>  ",emp3)
    println("Comparing Employee 1 and Employee 2===> ",emp1 == emp2) //can use .equals method also
    println("Comparing Employee 1 and Employee 3===> ",emp1 == emp3) //can use .equals method also
  }
}
