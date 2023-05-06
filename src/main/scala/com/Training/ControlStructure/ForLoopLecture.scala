package ControlStructure

// In for loop also, we can return values

object ForLoopLecture {
  def main(args: Array[String]): Unit = {
    val cities = List("Bangalore","Hyderabad","Chennai","Pune","Agra")

//    Syntax 1
    for(i <- 0 until cities.size)
      println(cities(i))

//    Syntax 2
    for(city <- cities)
      println(city)

//    Syntax 3 can't use yield
    cities.foreach(println)

//    Syntax 4
    val new_cities = for(city <- cities) yield
//      city.map(x=>x.toUpper)
      city.toUpperCase
    print(new_cities)

//    Syntax 5
    println("\n****************\n")
    for((city,index) <- cities.zipWithIndex)
      println(s"City is $city and index is $index")

//    Syntax 6
    for(city <- cities if city != "Hyderabad") yield
      println(city)
  }
}
