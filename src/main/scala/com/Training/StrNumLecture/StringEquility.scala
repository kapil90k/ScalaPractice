package StrNumLecture

object StringEquility extends App{
  val s1 = "Kapil"
  val s2 = "Kapil"
  val s3 = "K"+"apil"
  val s4: String = null
  val s5 = null
  val s6 : Int = 10

  println(s1 == s2)
  println(s1 == s3)
  println(s1 == s4)
  println(s1 == s5)    // Even though we are comparing String and null, it will not throw NullPointerException
  println(s2 == s6)   // Even though we are comparing String and Integer, it will not throw Exception

  // Creating multiline String
  val multiline = """This is
    literally a
    multiline String"""
  println(multiline)

//  Splitting String based on delimiter
  val grocerry_list = "eggs, milk , butter  ,  Coco Puffs   ".split(",")
  println("\nPrinting grocerry--->")
  grocerry_list.foreach(println)

//  Trimming String
  grocerry_list.foreach(x=>{
    println(x,x.size,x.trim.size)
  })
}
