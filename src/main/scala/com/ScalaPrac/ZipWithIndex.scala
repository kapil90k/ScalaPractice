package com.ScalaPrac

import scala.io.Source

object ZipWithIndex {

  def main(args: Array[String]): Unit = {
    val firstLine=Source.fromFile("D:\\OfficeProjects\\Tests\\test.txt").getLines().toList.head.split(",")
    val idx=firstLine.zipWithIndex.map{case(e,i)=>(i,e)}.toMap
    idx.foreach(println)
  }

}
