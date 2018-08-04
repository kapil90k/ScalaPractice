package com.ScalaPrac

import java.io.FileInputStream
import java.util.Properties
;

/***
  * This class gives the demo of converting your properties file into hashmap which can
  * be easily use through the code instead of using args(0)/args(1) etc.
  */


object PropFileMap {
  def main(args: Array[String]): Unit = {
    val propMap = getPropertiesAsMap(args(0))
    propMap.foreach{
      case(k,v) => println("key: "+k+" -> value: "+v)
    }
  }
  def getPropertiesAsMap(path:String): Map[String,String] ={
    val prop = new Properties()
    prop.load(new FileInputStream(path))
    import scala.collection.JavaConverters._
    prop.asScala.toMap
}
}
