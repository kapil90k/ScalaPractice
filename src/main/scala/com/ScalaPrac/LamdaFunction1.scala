package com.ScalaPrac

object LamdaFunction1 {
  def main(args: Array[String]): Unit = {
    println(lamdaPractice(9,calculateEO))
  }
/**
* passing function inside function
* @param num number
* @param f function which take one integer value and return string value after applying some logic
**/

  def lamdaPractice(num:Int,f:(Int)=>String): Boolean =
  {
    val isEven=f(num)
    isEven.equals("even")
  }

  def calculateEO(i: Int):String=
  {
    if(i%2==0) "even"
    else "odd"
  }
}
