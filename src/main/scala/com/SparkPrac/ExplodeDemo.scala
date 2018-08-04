package com.SparkPrac

import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession}

import scala.collection.mutable.ListBuffer
;

object ExplodeDemo extends App
{
  val spark=SparkSession.builder().master("local").getOrCreate()
  val sc=spark.sparkContext
  val file=sc.textFile("/home/cloudera/datasets/flatMapData.txt")

  val empRdd=file.flatMap(myCustFlat)

  def myCustFlat(line:String):List[Row]=
  {
    val splits=line.split(",")
    val listB=ListBuffer.empty[Row]
    val id=splits(0).toInt
    val name=splits(1).split(" ")
    val city=splits(2)
    val state=splits(3)
    for(i<-0 to name.size-1)
      {
        listB+=Row(id,name(i),city,state)
      }
    listB.toList
  }

  println("Printing RDD")
  empRdd.foreach(println)

  val schema=new StructType()
    .add("ID",IntegerType)
    .add("Name",StringType)
    .add("City",StringType)
    .add("State",StringType)

  val empDf=spark.createDataFrame(empRdd,schema)
  println("Printing DF")
  empDf.show()

  spark.stop()
}
