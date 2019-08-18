package com.ScalaPrac

import java.io.{BufferedWriter, FileWriter}
import java.time.LocalDateTime

import scala.io.Source

object ConvertToReadableDate {
  def main(args: Array[String]): Unit = {
    val file=Source.fromFile("D:\\OfficeProjects\\Datafiles\\asset_attribute_7June.csv").getLines().toList.tail
    val w = new BufferedWriter(new FileWriter("D:\\OfficeProjects\\Datafiles\\output2.txt"))
    val sdf=new java.text.SimpleDateFormat("yyyy-MM-dd")
    val list=file.foreach(x=>{
      val unixDate=x.split(",")(1).toLong
      val date=new java.util.Date(unixDate)
      w.write(unixDate+","+sdf.format(date)+"\n")
    })
  }
}
