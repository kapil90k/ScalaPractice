package com.JsonPrac

import java.io.FileWriter

import org.json.JSONObject
//import utilities.JsonUtil

//Delete This After Use.
//------------> Kapil Kumar

case class AssetAttribute(id: Option[Int], assetId : Option[Int],
                          templateId : Option[Int], parentId : Option[Int],
                          dataType: String, name : String, description : String,
                          dashboard : Boolean)

object JsonConverter extends App
{
  val inputJson="""{"powerdistribution_batteryvolts": "100","Action_1": {"messageTemplateName": "","update_status": "GREEN","actionTypeName": "ADD COLUMN","@timestamp": "2018/04/13 15:59:2725","ruleName": "IOT_R1","channelName": "","ruleFileName": "IOT_Ruleset.drl","actionName": "IOT_Action1"}
                  }"""

  println(s"Printing inputJson $inputJson")
  val jsObject=new JSONObject(inputJson)
  println(s"printing jsObject $jsObject")
  val a=jsObject.getJSONObject("Action_1").get("update_status").toString
  println(a)



//  Files.write(Paths.get("D:\\abc.txt"), a.getBytes(StandardCharsets.UTF_8))

  val fw = new FileWriter("D:\\abc.txt", true)
  try {
    fw.write(a)
    fw.write("\nMy name is kapil")
  }
  finally {
    fw.close()
  }

  val json="""{ "request": [ { "id": 1000, "assetId": 100, "templateId": 2000, "parentId": 1000, "dataType": "String", "name": "Serial Number", "description": "Unique number by which asset is identified", "dashboard": true }, { "id": 1001, "assetId": 100, "templateId": 2000, "parentId": 1001, "dataType": "String", "name": "Asset Name", "description": "Name assigned to an asset", "dashboard": true }, { "id": 1002, "assetId": 100, "templateId": 2000, "parentId": 1002, "dataType": "String", "name": "Manufacturer", "description": "Asset built by", "dashboard": true } ] }"""
  val jsObject2=new JSONObject(json)
  val parsedJson=jsObject2.getJSONArray("request")
  val listAttribs=(for(i <- 0 until parsedJson.length()) yield
    {
      JsonUtil.fromJson[AssetAttribute](parsedJson.get(i).toString)
    }).toList
  listAttribs.foreach(println)

  val list=List(10,20,30,40,50)
  val listString=list.mkString(",")
  println("Printing listString: "+listString)

}
