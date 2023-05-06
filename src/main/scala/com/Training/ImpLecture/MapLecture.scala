package ImpLecture

import scala.collection.mutable

object MapLecture {
  def main(args: Array[String]): Unit = {
    val city_map = collection.immutable.Map(
      "Agra" -> "Uttar Pradesh",
      "Hyderabad" -> "Andhra Pradesh",
      "Chennai" -> "Tamil Nadu",
      "Bangalore" -> "Karnataka",
      "Allepy" -> "Kerala")

    val lang = mutable.Map(
      "Hindi"->"Uttar Pradesh",
      "Punjabi"->"Punjabi",
      "Malayalam"->"Kerala",
      "Telugu"->"Telangana"
    )
    println(city_map.getClass)
    println(lang.getClass)
    println(lang.toMap.getClass)

    //    Reversing the map
    val reverse_city_map = city_map.map(x=>{
      (x._2,x._1)
    })
//    Iterating map
    city_map.foreach(x=>{
      println(x._1+" ** "+x._2)
    })

  }

}
