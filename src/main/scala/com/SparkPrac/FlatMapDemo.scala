package com.SparkPrac

import org.apache.spark.sql.types.{ArrayType, IntegerType, StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession, functions}
;

object FlatMapDemo extends App
{
  val spark=SparkSession.builder().master("local").getOrCreate()
  val sc=spark.sparkContext
  val file=sc.textFile("/home/cloudera/datasets/flatMapData.txt")

  val empRdd=file.map(line=>
  {
    val splits=line.split(",")
    val id=splits(0).toInt
    val name=splits(1).split(" ")
    val city=splits(2)
    val state=splits(3)
    Row(id,name,city,state)
  })

  println("Printing RDD")
  empRdd.foreach(println)

  val schema=new StructType()
    .add("ID",IntegerType)
    .add("Name",ArrayType(StringType))
    .add("City",StringType)
    .add("State",StringType)

  val empDf=spark.createDataFrame(empRdd,schema)
  println("Printing dataframe without exploding--->")
  empDf.show()

  //Exploding column Name----->
  println("Printing dataframe with exploding column--->")
  empDf.withColumn("Name",functions.explode(empDf.col("Name"))).show()

  spark.stop()
}
