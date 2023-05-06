package ImpLecture

import org.json.JSONObject

object JsonLecture {
  def main(args: Array[String]): Unit = {
    val report =
      """
        |{
        |  "accounting": [
        |    {
        |      "firstName": "John",
        |      "lastName": "Doe",
        |      "age": 23
        |    },
        |    {
        |      "firstName": "Mary",
        |      "lastName": "Smith",
        |      "age": 32
        |    }
        |  ],
        |  "sales": [
        |    {
        |      "firstName": "Sally",
        |      "lastName": "Green",
        |      "age": 27
        |    },
        |    {
        |      "firstName": "Jim",
        |      "lastName": "Galley",
        |      "age": 41
        |    }
        |  ]
        |}
      """.stripMargin
    println(report)
    println("Iterating accounting Array===>")
    val report_json = new JSONObject(report)
    val accounting = report_json.getJSONArray("accounting")
    for (i <- 0 until accounting.length())
      println(accounting.get(i))

    println("\n\nIterating sales Array===>")
    val sales = report_json.getJSONArray("sales")
    for (i <- 0 until sales.length()) {
      val sale_obj = sales.getJSONObject(i)
        println(s"first_name: ${sale_obj.getString("firstName")} ** last_name: ${sale_obj.getString("lastName")} ** age: ${sale_obj.getInt("age")}")
    }
  }
}
