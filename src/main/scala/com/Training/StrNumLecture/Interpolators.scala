package StrNumLecture

object Interpolators {
  def main(args: Array[String]): Unit = {
    //  Substituting variables in String
    val name = "Kapil"
    val city = "Bangalore"
    val age = 20
    val weight = 60.5432
    println(s"Hi, my name is $name and I live in $city")
    println(s"Hi, my name is $name and I live in $city")
    println(s"Hi, my name is $name and my age is ${age * 2}")
    println(s"$name age is $age, ${age == 20}")

    println(f"Hi, my name is $name and my weight is: $weight%.0f")
    println(f"Hi, my name is $name and my weight is: $weight%.3f")
    println(f"Hi, my name is $name and my weight is: $weight%.6f")

    println("%s is %d year old and weight is %f".format(name,age,weight))
  }
}
