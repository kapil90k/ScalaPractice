package com.HbasePrac

import java.util

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.filter.{FilterList, PrefixFilter, RegexStringComparator, RowFilter}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.TableName
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Test
{

  def close(table: Table, connection: Connection):Unit={
    table.close()
    connection.close()
  }

  def main(args: Array[String]): Unit = {
    val conf = HBaseConfiguration.create
    conf.set("hbase.zookeeper.quorum","quickstart.cloudera")
    conf.set("hbase.master","quickstart.cloudera:60000")
    conf.set("hbase.zookeeper.property.clientPort","2181")

    val connection=ConnectionFactory.createConnection(conf)
    val admin = new HBaseAdmin(conf)
    val tableDescriptor = admin.listTables
    tableDescriptor.foreach(x=>println(x.getNameAsString))
    val table =connection.getTable(TableName.valueOf("test"))
    val scan =new Scan()

    val keyRegEx = new RegexStringComparator("*-pierce")
    val rowFilter = new RowFilter(CompareOp.EQUAL, keyRegEx)
    scan.setFilter(rowFilter)

    val scanner=table.getScanner(scan)
    val listBuffer = mutable.ListBuffer[(Map[String, String], String)]()
    import scala.collection.JavaConverters._
    scanner.asScala.foreach(row => {
      val rowKey = Bytes.toString(row.getRow)
      val resultMap = buildMap(row)
      listBuffer.append( (resultMap) )
    })
    val list=listBuffer.toList

    list.foreach(x=>{
      print(x._2+" ===> ")
      x._1.foreach(x=>println(x._1+" "+x._2))
    }
    )

    close(table,connection)
  }
  def getAlertRows(connection: Connection,table:Table) : List[(Map[String, String], String)]={
    val filterRows=List("SRP~138")
    val scan = new Scan()
    scan.setFilter(getFilter(filterRows))
    scan.addFamily(Bytes.toBytes("alerts"))
    val scanner:ResultScanner=table.getScanner(scan)
    val listBuffer = mutable.ListBuffer[(Map[String, String], String)]()
    import scala.collection.JavaConverters._
    scanner.asScala.foreach(row=>{
      val result=buildMap(row)
      listBuffer.append(result)
    })
    listBuffer.toList
  }
  def buildMap(row:Result): (Map[String,String],String) = {
    var rowKeyContent: util.NavigableMap[Array[Byte], util.NavigableMap[Array[Byte], Array[Byte]]]=row.getNoVersionMap
    import collection.JavaConversions._
    val rowKey=Bytes.toString(row.getRow)
    val value = for {
      (cf , m) <- rowKeyContent
      (cq, v) <-m
    } yield (Bytes.toString(cf) + ":" + Bytes.toString(cq) , Bytes.toString(v))
    (value.toMap,rowKey)
  }
  def getFilter(filter:List[String]): FilterList = {
    val allFilters = new FilterList(FilterList.Operator.MUST_PASS_ONE)
    filter.foreach(x=>{
      allFilters.addFilter(new PrefixFilter(Bytes.toBytes(x)))
    })
    allFilters
  }

}
