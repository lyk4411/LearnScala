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
  def maxListImpParm[T](elements: List[T])
                       (implicit ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(ordering)
        if (ordering.gt(x, maxRest)) x
        else maxRest
    }
//  def maxList[T](elements: List[T])
//                (implicit ordering: Ordering[T]): T =
//    elements match {
//      case List() =>
//        throw new IllegalArgumentException("empty list!")
//      case List(x) => x
//      case x :: rest =>
//        val maxRest = maxList(rest)     // (ordering) is implicit
//        if (ordering.gt(x, maxRest)) x  // this ordering is
//        else maxRest                    // still explicit
//    }
//  def maxList[T](elements: List[T])
//                (implicit ordering: Ordering[T]): T =
//    elements match {
//      case List() =>
//        throw new IllegalArgumentException("empty list!")
//      case List(x) => x
//      case x :: rest =>
//        val maxRest = maxList(rest)
//        if (implicitly[Ordering[T]].gt(x, maxRest)) x
//        else maxRest
//    }
  def maxList[T : Ordering](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if (implicitly[Ordering[T]].gt(x, maxRest)) x
        else maxRest
    }


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
    println
//    val bobsPrompt = new PreferredPrompt("relax> ")
//    Greeter.greet("Bob")(bobsPrompt)
    implicit val prompt = new PreferredPrompt("Yes, master> ")
    implicit val drink = new PreferredDrink("tea")
    Greeter.greet("Joe")(prompt, drink)
    println
    Greeter.greet("Joe")

    println(maxListImpParm(List(1,5,10,3)))
    println(maxListImpParm(List(1.5, 5.2, 10.7, 3.14159)))
  }


  case class Rectangle(width: Int, height: Int)
  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }
}
//class PreferredPrompt(val preference: String)
//object Greeter {
//  def greet(name: String)(implicit prompt: PreferredPrompt) = {
//    println("Welcome, " + name + ". The system is ready.")
//    println(prompt.preference)
//  }
//}

class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt,
                          drink: PreferredDrink) = {

    println("Welcome, " + name + ". The system is ready.")
    print("But while you work, ")
    println("why not enjoy a cup of " + drink.preference + "?")
    println(prompt.preference)
  }
}


