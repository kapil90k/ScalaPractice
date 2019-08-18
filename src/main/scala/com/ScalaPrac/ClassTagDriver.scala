package com.ScalaPrac

import scala.reflect.ClassTag

object ClassTagDriver extends App
{
  def showClassName[T]()(implicit classTag: ClassTag[T]):Option[T]={
    if(classTag.runtimeClass == classOf[Boolean])
      {
        println("Inside Boolean")
        return Some(classTag.runtimeClass.asInstanceOf[T])
      }
    else if(classTag.runtimeClass == classOf[Double])
    {
      println("Inside Double")
      return Some(classTag.runtimeClass.asInstanceOf[T])
    }else if(classTag.runtimeClass == classOf[Int])
    {
      println("Inside Int")
      return Some(classTag.runtimeClass.asInstanceOf[T])
    }else if(classTag.runtimeClass == classOf[String])
    {
      println("Inside String")
      return Some(classTag.runtimeClass.asInstanceOf[T])
    }
    None
  }

  println("This is "+showClassName[String]().get)
  println("This is "+showClassName[Double]().get)
  println("This is "+showClassName[Int]().get)
  println("This is "+showClassName[Boolean].get)


}
