package StrNumLecture

object NumberLecture extends App {
  val num = 19.45
  println(num.toInt + " " + num.toInt.getClass.getSimpleName)
  println(num.toLong + " " + num.toLong.getClass.getSimpleName)
  println(num.toDouble + " " + num.toDouble.getClass.getSimpleName)
  println(num.toFloat + " " + num.toFloat.getClass.getSimpleName)

  println(1000L.getClass.getSimpleName)
  println(1000d.getClass.getSimpleName)
  println(1000f.getClass.getSimpleName)


  println(Int.MaxValue , Int.MinValue)
  println(Short.MaxValue , Short.MinValue)
  println(Long.MaxValue , Long.MinValue)
  println(Byte.MaxValue , Byte.MinValue)

}
