package LearnScala

/**
  * Created by lyk on 2019-9-11.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex21 {
//  implicit def intToString(x: Int) = x.toString
//  implicit def doubleToInt(x: Double) = x.toInt
//  implicit def int2double(x: Int): Double = x.toDouble
  implicit def intToRational(x: Int) = new Rational(x)

  def main(args: Array[String]) {
//    val i: Int = 3.5
//    println(i)
    val oneHalf = new Rational(1, 2)
//    println(oneHalf + 2)
    println(2 + oneHalf)
    println(new Rational(2) + oneHalf)
    println(new Rational(2, 1) + oneHalf)

    val myRectangle = 3 x 4
    println(myRectangle)
  }


  case class Rectangle(width: Int, height: Int)
  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }
}
