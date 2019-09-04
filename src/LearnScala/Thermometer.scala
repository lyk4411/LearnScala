package LearnScala

/**
  * Created by lyk on 2019-9-4.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

class Thermometer {

  var celsius: Float = _

  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float) = {
    celsius = (f - 32) * 5 / 9
  }
  override def toString = fahrenheit + "F/" + celsius + "C"
}

object Thermometer{
  def main(args: Array[String]) {
    val t = new Thermometer()
    println(t)
    t.celsius = 100
    println(t)
    t.fahrenheit = -40
    println(t)
  }
}