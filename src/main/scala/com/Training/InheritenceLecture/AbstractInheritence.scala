package InheritenceLecture

abstract class Vehicles {
  def wheels(): Int
  def geers(): Int={
    5
  }
}

class Bike() extends Vehicles {
  def wheels(): Int= {
    4
  }

  override def geers(): Int = {
    4
  }
}

class Rickshaw() extends Vehicles {
  def wheels(): Int= {
    3
  }
  override def geers(): Int = {0}
}

object DemoAbstract {
  def main(args: Array[String]): Unit = {
    val r = new Rickshaw
    val b = new Bike
    println("Wheels in Richshaw: ", r.wheels())
    println("Wheels in Bike: ", b.wheels())
    println("Geers in Richshaw: ", r.geers())
    println("Geers in Bike: ", b.geers())
  }

}
