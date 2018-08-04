package com.SparkPrac

import org.apache.spark.sql.SparkSession

// Creating the Schema of dataframe using case class

case class Employee(empId:Integer,empName:Array[String],empCity:String,empState:String)

object CaseClassDF extends App
{
  val spark=SparkSession.builder().master("local").getOrCreate()
  val sc=spark.sparkContext
  val file=sc.textFile("D:\\IntellijWorkspace\\ScalaPractice\\src\\main\\ScalaPrac\\com\\flatMapData.txt")

  val empRdd=file.map(line=>
  {
    val splits=line.split(",")
    val id=splits(0).toInt
    val name=splits(1).split(" ")
    val city=splits(2)
    val state=splits(3)
    Employee(id,name,city,state)
  })

  import spark.implicits._

  val empDf=empRdd.toDF
  empDf.show()
  spark.stop()
}
