package com.SparkPrac

import org.apache.spark.sql.{Encoders, Row, SparkSession, functions}

//In this code, I have created the schema using Encoders api with case class.

case class Employee1(empId:Integer,empName:Array[String],empCity:String,empState:String)

object CaseClassEncoder extends App
{
  val spark=SparkSession.builder().master("local").getOrCreate()
  val sc=spark.sparkContext
  val file=sc.textFile("D:\\IntellijWorkspace\\ScalaPractice\\Public\\Files\\flatMapData.txt")

  val empRdd=file.map(line=>
  {
    val splits=line.split(",")
    val id=splits(0).toInt
    val name=splits(1).split(" ")
    val city=splits(2)
    val state=splits(3)
    Row(id,name,city,state)
  })

  val schema=Encoders.product[Employee1].schema
  val empDf=spark.createDataFrame(empRdd,schema)
  empDf.show()
  empDf.withColumn("Name",functions.explode(empDf.col("empName"))).show()
  spark.stop()
}
