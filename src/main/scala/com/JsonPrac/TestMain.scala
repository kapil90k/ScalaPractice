package com.JsonPrac

import org.apache.commons.lang3.StringEscapeUtils

import scala.collection.mutable

case class Address(street:Integer,main:Integer,city:String,state:String)
case class Contact(mobile:Long)//,floor:Int)
case class Profile(fName:String,address: Address,lName:String,office:String,hobbies:List[Any])

object TestMain extends App
{
  val str:Option[String]=None
  val myAdd=Address(20,28,"Bangalore","Karnataka")
  val contact=Contact(123456789)
  val myProfile=Profile("Kapil",null,"Kumar","Kogentix",List("Eating",contact,"Reproducing"))
  val a=myProfile.copy(address =myAdd )
  val profileJson=JsonUtil.toJson(a)
  println(profileJson)

  val jsString="{\"fName\":\"Kapil\",\"address\":{\"street\":20,\"main\":28,\"city\":\"Bangalore\",\"state\":\"Karnataka\"},\"lName\":\"Kumar\",\"office\":\"Kogentix\",\"hobbies\":[\"Eating\",{\"mobile\":123456789},\"Reproducing\"]}"
  val jsObject=JsonUtil.fromJson[Profile](jsString)
//  println(jsObject)
//  println("Printing list from Profile Object:  "+jsObject.hobbies)

  // ***************Using StringEscapeUtils.unescapeJavaScript to remove "\" from strings ***************
  val kap="""my name is \\ \\kapil \\kumar"""
//  println("Printing kap:--- \n"+kap)
  val jsStringWithoutEsc=StringEscapeUtils.unescapeJson(kap)
  println("Printing jsStringWithoutEsc:--- \n"+jsStringWithoutEsc)

  /***********************************************************************************************************/
  case class Metadata(configurations: List[Param])
  case class Param(key: String, value: String)

  val myJsString="""{"configurations":[{"rowkey": "Kapil"},{"columnFamily": "Kumar"},{"baseTableName": "Kogentix"}]}"""
//  val metadataJson=Json.fromJson[Metadata](parseJson).get;  println("Printing metadataJson: "+metadataJson)
//  val metadataMap=metadataJson.configurations.map(x=>(x.key,x.value)).toMap;   println("Printing metadataMap")
//  println(metadataMap)

  /******************************* Checking Default Values in Case Class ***************************************************************/

  case class Office(name:String,city:String,pin:Int,state:String="Karnataka")
  val office=Office("Shubham","Kota",5600,"Rajsthan")
  println("Printing Offcie: "+office)
  val officeItr=for(i<- 1 to 5) yield
    Office(i.toString,(i*10).toString,(i*100))
  officeItr.foreach(println)

  /********************** Converting Case class to Map **************************************************/

    def officeToMap(office: Office):Map[String,Any]={
  val fieldArray=office.getClass.getDeclaredFields.map(x=>x.getName)
  val valueArray=Office.unapply(office).get.productIterator.toSeq
//      val a=fieldArray zip valueArray
  val as=fieldArray.zip(valueArray).toMap
      as
    }
  val myOffice=Office("Shubham","Kota",5600,"Rajsthan")
  val officeMap=officeToMap(myOffice)
  println("Printing office to map----->\n"+officeMap)

/********************** Converting Case class to Map **************************************************/
/*case class City(capital:String,state:String)
  {
    def toMap(): Map[String,String]=
    {
      val map= scala.collection.mutable.Map[String,String]
    }
  }*/

  val myMap=Map(1->"One is my name",2->"Two is my name",3->"Three is my name",4->"Four is my name",5->"Five is my name")
  val one=myMap.get(1)
  val two=myMap.get(2)
  println(one)
  println(two.mkString("**"))
  println(two.get)

  println("********************************* List To Json String *********************************************")

  val myList=List("Kapil","Shubham","Varsha","Bittu","Didi")
  val myListJson= JsonUtil.toJson(myList)
  println("myListJson:  ************  "+myListJson+"-*-*-:  "+myList)


}
