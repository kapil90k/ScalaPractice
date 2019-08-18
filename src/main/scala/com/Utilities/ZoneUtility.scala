package com.Utilities

import java.time.ZoneId

import java.io.{BufferedWriter, FileWriter}
import java.time.format.DateTimeFormatter
import java.time.{LocalDateTime, ZoneId}

object ZoneUtility {
  def main(args: Array[String]): Unit = {
    val w = new BufferedWriter(new FileWriter("D:\\IntellijWorkspace\\ScalaPractice\\Public\\Files\\zoneOutput.txt"))
    val animalDesc=List("It is known as",
      "most important domestic animal",
      "Everyone gives respect ",
      "the holiest animal among all ",
      "varieties differentiating in the shape,")
    val animalId=List("ABC~1821",
      "XYZ~1512",
      "ABC~1372",
      "ABC~1656")
    val zoneId = ZoneId.systemDefault()
    val startVal = 179
    val endVal   = 2000
    val startAttrib=0
    val endAttrib=animalDesc.length-2
    val startTm=1000
    val endTm=20000
    val rnd = new scala.util.Random
    for(i<-0 until 12)
    {
      val t1=LocalDateTime.now.minusDays(2).plusDays(i)

      for(j<-0 until animalId.length)
      {
        for(k<-0 until 12)
        {
          val ts = (t1.atZone(zoneId).toEpochSecond+startTm + rnd.nextInt( (endTm - startTm) + 1 )) * 1000
          val value=startVal + rnd.nextInt( (endVal - startVal) + 1 )
          val valueAttribNameIndex=startAttrib + rnd.nextInt( (endAttrib - startAttrib) + 1 )
          w.write(animalId(j)+","+ts+","+animalDesc(valueAttribNameIndex)+","+value+"\n")
          println(animalId(j)+","+ts+","+animalDesc(valueAttribNameIndex)+","+value)
        }
      }
    }
    w.flush()
    w.close()
  }
  def shortDateFormat(dt: LocalDateTime): String = {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    formatter.format(dt)
  }
}

