package ImpLecture

import scala.collection.mutable.ListBuffer

object ListbufferLecture extends App{
val lb = ListBuffer("Agra","Mathura")
  println(lb)
  lb.append("Banaras")
  println(lb.getClass)
  println(lb.toArray.getClass)
  println(lb.toList.getClass)
}
