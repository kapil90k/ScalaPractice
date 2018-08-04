package com.ScalaPrac

object LamdaFunction2
{
  def main(args: Array[String]): Unit = {
    val isEven=lamdaPractice(8,(num:Int)=>{
      if(num % 2 ==0) true
      else false
    })
    println(isEven)
  }
  def lamdaPractice(i:Int,isEven:(Int)=> Boolean): Boolean =
  {
    isEven(i)
  }
}
