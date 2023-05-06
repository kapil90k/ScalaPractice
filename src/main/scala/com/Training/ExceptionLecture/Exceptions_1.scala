package ExceptionLecture

object Exceptions_1 {
  def main(args: Array[String]): Unit = {
//    Usage 1
    val num = 100
    try {
      for (i <- 5 until -1 by -1)
        println(i, 100 / i)
    }
    catch{
          case e : ArithmeticException => {
            println("Arithmetic Exception, now throwing NullPointerException")
            //        throw new NullPointerException
          }
          case e: Exception => println("Global Exception Class")
          case _ => println("Exception ignored")
        }
    finally {
      println("Entered into Finally clause, time to close connections...")
    }
  }
}
