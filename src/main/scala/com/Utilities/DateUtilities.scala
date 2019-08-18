package com.Utilities

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Random

object DateUtilities extends App
{
  def shortDateFormat(dt: LocalDateTime): String = {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    formatter.format(dt)
  }
  val autoId="FL02~838760340-S-00"
var value=100
  for(i<-0 until 60){
  val t1 = LocalDateTime.now.minusDays(30).plusDays(i)
  val ts1 = shortDateFormat(t1)
    println(s"""put 'iot_asset_date_2', '$ts1-$autoId', 'data:chassis_odometer', $value""")
    value+=20
//    println(ts1)
  }

  val mySeq:Seq[String]=Seq("Kapil","Kumar","Singh","Shubham","Kota")
  mySeq.filter(x=>{
    x.size==5
  }).foreach(println)

}
