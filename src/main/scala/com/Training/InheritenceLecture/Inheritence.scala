package InheritenceLecture

class Polygon{
  def area(): Double={
    0.0
  }
}

class Rectangle(length: Double, width: Double) extends Polygon {
  override def area(): Double = {
    val area = length * width
    area
  }
}

class Triangle(length: Double, width: Double) extends Polygon {
  override def area(): Double = {
    val area = length * width / 2
    area
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    val p = new Polygon
    val r = new Rectangle(20.14, 50.47)
    val t = new Triangle(20.14, 50.47)
    println(p.area())
    println(r.area())
    println(t.area())
  }

}
