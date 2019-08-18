package com.JsonPrac

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, SerializationFeature}
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object JsonUtil {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
  mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

  def toJson(value: Any): String = {
    mapper.writeValueAsString(value)
  }

  def fromJson[T](json: String)(implicit m : Manifest[T]): T = {
    mapper.readValue[T](json)
  }

  def toJsonfailedonempty(value: Any): String = {
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    mapper.writeValueAsString(value)
  }
  def toJsonwithoutnull(value: Any): String = {
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.writeValueAsString(value)
  }
  def decodeSpecialCharsInJson(jsonString: String): String = {
    jsonString.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;","&")
  }


  /*def toJson(value: Map[Symbol, Any]): String = {
   toJson(value map { case (k,v) => k.name -> v})
  }
  def toJsonOrderMap(value: scala.collection.immutable.ListMap[String, Any]): String = {
     toJson(value map { case (k,v) => Symbol(k).name -> v})
 }
  def getObjectMapper(): ObjectMapper ={
    this.mapper;
  }
  def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)
*/

  

}


