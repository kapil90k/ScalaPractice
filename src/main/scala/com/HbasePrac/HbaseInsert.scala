package com.HbasePrac

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.sql.{DataFrame, SparkSession}

object HbaseInsert {

  def getHbaseConf():Configuration ={
    val conf = HBaseConfiguration.create
    conf.set("hbase.zookeeper.quorum","quickstart.cloudera")
    conf.set("hbase.master","quickstart.cloudera:60000")
    conf.set("hbase.zookeeper.property.clientPort","2181")
    conf
  }

  def createDf(spark: SparkSession) : DataFrame= {
    spark.read.option("header","true").csv("D:\\OfficeProjects\\ImportantFiles\\elkds.csv")
  }
  def main(args: Array[String]): Unit = {

    val spark=SparkSession.builder().master("local").appName("Hbase POC").getOrCreate()
    val hconf=getHbaseConf()
    val admin = new HBaseAdmin(hconf)
    val df=createDf(spark)
    listTables(admin)
    saveDfHbase(df)
    hbaseGetRowKey("100",hconf)
    hbaseScanExample(hconf)
  }

  def saveDfHbase(df:DataFrame)={
  df.foreachPartition(rowItr=>{
  val conf=getHbaseConf()
  val table = new HTable(conf, "Training")
    val mutationList = new java.util.ArrayList[Mutation]
    rowItr.foreach(row=>{
      val key=row.getAs[String]("Id")
      val put=new Put(Bytes.toBytes(key))
      put.addColumn(Bytes.toBytes("personal"),Bytes.toBytes("Name"),Bytes.toBytes(row.getAs[String]("Name")))
      put.addColumn(Bytes.toBytes("personal"),Bytes.toBytes("Course"),Bytes.toBytes(row.getAs[String]("Course")))
      put.addColumn(Bytes.toBytes("personal"),Bytes.toBytes("Age"),Bytes.toBytes(row.getAs[String]("Age")))
      put.addColumn(Bytes.toBytes("location"),Bytes.toBytes("City"),Bytes.toBytes(row.getAs[String]("City")))
      put.addColumn(Bytes.toBytes("location"),Bytes.toBytes("State"),Bytes.toBytes(row.getAs[String]("State")))

      /*mutationList.add(put)*/
      table.put(put)
    })
    /*if(mutationList.size()>5)
    {
      table.batch(mutationList,null)
    }*/
    table.close()
})
  }

  def listTables(admin:HBaseAdmin):Unit={
    val tableDescriptor = admin.listTables
    tableDescriptor.foreach(x=>println(x.getNameAsString))
  }

  def hbaseGetRowKey(id:String,hconf:Configuration):Unit={
    val get=new Get(Bytes.toBytes(id))
    val table = new HTable(hconf, "Training")
    val result=table.get(get)
    val city=result.getValue(Bytes.toBytes("location"),Bytes.toBytes("City"))
    println(Bytes.toString(city))

  }

  def hbaseScanExample(hconf: Configuration): Unit = {
    val table = new HTable(hconf, "Training")
    val scan=new Scan()

    //For putting filter on scan object
    /*val filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
      new RegexStringComparator("regex filter for rowkey"))
    scan.setFilter(filter)*/

    scan.addFamily(Bytes.toBytes("location"))
    val result=table.getScanner(scan)
    val itr=result.iterator()

    while(itr.hasNext)
      {
        val result=itr.next()
        val city=result.getValue(Bytes.toBytes("location"),Bytes.toBytes("State"))
        println(Bytes.toString(city))
      }

  }
}
