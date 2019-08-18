/*
package com.ScalaPrac

import java.util.Formatter.DateTime
import java.util.UUID
import org.joda.time.DateTime
import org.fluttercode.datafactory.impl.DataFactory

import scala.util.Random
class DataGenerator
{
  val df = new DataFactory
  val rd = new Random()
def generateCDR(num:Integer): List[String] =
  {
    val dataList=for (i <- 1 to num) yield
    {
      val id= UUID.randomUUID()
      val callingNum = df.getNumberText(10)
      val calledNum = df.getNumberText(10)
      val t1 = System.currentTimeMillis() + rd.nextInt
      val t2 = t1 + 2 * 60 * 1000 + rd.nextInt(60 * 1000) + 1
      var d1 = new DateTime(t1)
      var d2 = new DateTime(t2)
      var callType:String=""

      if ( rd.nextInt() % 2 == 0){
        callType = "VOICE"
      } else {
        callType = "SMS";
      }
      if ("SMS" == callType) {
        d2 = new DateTime(t1)
      }

      var callResult = "ANSWERED"
      if ((i % 10 )== 0 && callType == "VOICE") {
        callResult = "BUSY"
        d2 = new DateTime(t1)
      }
      val charge = rd.nextFloat()
      val dataGenerated=id.toString()+","+callingNum+","+calledNum+","+d1.toString()+","+d2.toString()+
        ","+callType+","+charge+","+callResult
      dataGenerated
    }
    dataList.toList
  }
}

object DataGenerator extends App
{
  val dg=new DataGenerator
  val list=dg.generateCDR(225)

  list.foreach(println)
  val data="ddbaea4e-4cfa-416b-a96c-d567103fa0f9,9917618284,5084342972,2018-03-31T13:12:24.784+05:30,2018-03-31T13:12:24.784+05:30,SMS,0.480462,ANSWERED"
  val a=data.split(",")(5)
  print("Value of a:  "+a)

//  println("\n\n"+list)
}
*/
