package com.SparkPrac

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
;

object DivideRdd extends App
{
  val spark=SparkSession.builder().master("local").config("SparkPrac.sql.warehouse.dir", "/tmp/TEMP/kapil/").getOrCreate()
  val sc=spark.sparkContext
  val list=List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
  val listRdd=sc.parallelize(list)

  val filteredRdd=listRdd.partitionBy(_ % 2 == 0)

  val evenRdd=filteredRdd._1
  val oddRdd=filteredRdd._2
  println("printing evenRDD")
  evenRdd.foreach(println)
  println("****************************")
  println("printing oddRDD")
  oddRdd.foreach(println)

  implicit class RDDOps[T](rdd: RDD[T]) {
    def partitionBy(f: T => Boolean): (RDD[T], RDD[T]) = {
      val passes = rdd.filter(f)
      val fails = rdd.filter(e => !f(e)) // Spark doesn't have filterNot
      (passes, fails)
    }
  }
}
