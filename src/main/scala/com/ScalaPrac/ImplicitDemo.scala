package com.ScalaPrac

/*
This class is giving the demo for implicit type of class. Keyword implicit is prefixed with class to define the extra methods for that particular class.
Implicit class primary constructor takes exactly one arguement. All the defined methods inside this class goes under the object which is mentioned in primary constructor.
Here Animal class has only one methods i.e. animalType but on line 14 and line 15 we are calling two more methods of animal class. These methods will be implicitely
available to Animal class objects.
*/

object ImplicitDemo extends App
{
  val animal=new Animal
  println(animal.animalType("horse"))
  animal.countLegs("dog")
  animal.hasTail("horse")

 implicit class AnimalImpl(animal:Animal)
  {
    def countLegs(animalName:String): Unit =
    {
        if(animalName.equals("horse"))
          println(s"$animalName has 4 legs ")
        else println(s"$animalName has 2 legs ")
    }
    def hasTail(animalName:String):Unit=
    {
      if(animalName.equals("horse"))
        println(s"$animalName has 1 tail ")
      else println(s"$animalName don't have any tail ")
    }
  }
}

class Animal
{
  def animalType(name:String): String=
  {
    var typeOfAnimal=""
    if(name.equals("horse"))
      typeOfAnimal="vagetarian"
    else typeOfAnimal="non-vegetarialn"
    typeOfAnimal
  }
}
