package InheritenceLecture

trait Insurance{
  def insurance_company: String
  def insurance_validity: String
}

trait Licence{
  def licence_age(age: Int):String={
    if(age<18)
      "Not Valid"
    else "Valid"
  }
  def licence_state(city: String): String
}

class ola_driver extends Insurance with Licence{
  override def insurance_company: String = "ICICI Lombard"

  override def insurance_validity: String = "2 years left"

  override def licence_state(city: String): String = {
    city match {
      case "Bangalore"=> "Karnataka"
      case "Chennai" => "Tamilnadu"
      case "Agra" => "Uttar Pradesh"
      case "Bhopal" => "Madhya Pradesh"
      case _ => "Delhi"
    }
  }
}

object TraitLecture extends App{
  val ola_obj1 = new ola_driver
  println(ola_obj1.insurance_company)
  println(ola_obj1.insurance_validity)
  println(ola_obj1.licence_state("Bangalore"))
  println(ola_obj1.licence_age(22))
}
