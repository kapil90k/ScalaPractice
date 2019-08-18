package com.JsonPrac

import org.json.JSONObject

object JsonTest {
  def main(args: Array[String]): Unit = {
    val jsStr="{\"template\":{ \"id\": 100, \"tag\": \"healthSummary\", \"name\": \"Health Summary\", \"description\": null, \"assetTypeId\": 1000, \"lastModifiedBy\": null, \"dateCreated\": \"2018-05-12 02:01:04\", \"dateUpdated\": \"2018-05-12 02:01:04\" }}"
    val jsObj=new JSONObject(jsStr)
    println(jsObj.getJSONObject("template"))
    val a=jsObj.getJSONObject("template").toString()
    println(a)
  }
}
