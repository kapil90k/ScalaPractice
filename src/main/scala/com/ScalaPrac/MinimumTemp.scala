package com.ScalaPrac

import scala.io.Source

//import ScalaPrac.io.Source

/**
  * Here I am giving demo of some shorthand tricks of ScalaPrac.
  * */
case class Temperature(stationId:String,date:String,tType:String,temp:Int)
object MinimumTemp extends App{
val fileList=Source.fromFile("Some csv file path").getLines().drop(1)
  val minTemp=fileList.map(x=>{
    val splits=x.split(",")
    (splits(0),splits(3).toInt)}
  ).filter(_._1.equals("ITE00100554")).map(_._2).reduce((x,y)=>if(x<y) x else y )
println(minTemp)
}
