package com.HbasePrac

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.HBaseAdmin
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object HbaseGetTables {
  def main(args: Array[String]): Unit = {

    val spark=SparkSession.builder().appName("").master("local").config("header","true").getOrCreate()
   var df= spark.read.option("header","true").csv("D:\\OfficeProjects\\ImportantFiles\\elkds.csv")
    df.show()

    val vehicleId=df("vehicle_id")
    val con=concat_ws("~", df("vehicle_id"), df("attr_name"))
    df = df
      .withColumn("index_id", concat_ws("~", df("vehicle_id"), df("attr_name")))
      .withColumn("hbase_id", df("vehicle_id"))


    spark.stop()
  }
}
