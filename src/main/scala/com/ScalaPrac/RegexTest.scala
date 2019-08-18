package com.ScalaPrac

import java.util.regex.Pattern

object RegexTest {
  def main(args: Array[String]): Unit = {
    val str="SRP,CRP"
    val regex=str.split(",").map(x=>{
      s"(.*-$x)|"
    }).mkString
    println(regex)
    println(regex.substring(0,regex.size-1))
    val exp="["+str.replace(",","|")+"]"
    println(exp)
    val pattern=Pattern.compile(exp)
  }

}
