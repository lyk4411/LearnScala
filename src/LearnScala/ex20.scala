package LearnScala

/**
  * Created by lyk on 2019-9-9.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex20 {
//  new RationalTrait {
//    val numerArg = 1
//    val denomArg = 2
//  }
  val x = 2
  new {
       val numerArg = 1 * x
       val denomArg = 2 * x
     } with RationalTrait
  object twoThirds extends {
    val numerArg = 2
    val denomArg = 3
  } with RationalTrait

  def main(args: Array[String]) {
    object Demo {
         val x = { println("initializing x"); "done" }
       }
    println(Demo.x)
    println(Demo.x)


    println(new LazyRationalTrait {
      val numerArg = 1 * x
      val denomArg = 2 * x
    })

    val lassie = new Dog
    val bootsie = new Dog
    val bessy = new Cow
    lassie eat (new bootsie.SuitableFood)
//    lassie eat (new bessy.SuitableFood)

    for (d <- Direction.values) print(d + " ")
  }

}

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}
abstract class Fruit {
  val v: String // `v' for value
  def m: String // `m' for method
}

abstract class Apple extends Fruit {
  val v: String
  val m: String // OK to override a `def' with a `val'
}

//abstract class BadApple extends Fruit {
//  def v: String // ERROR: cannot override a `val' with a `def'
//  def m: String
//}

trait AbstractTime {
  var hour: Int
  var minute: Int
}
//
//trait AbstractTime {
//  def hour: Int          // getter for `hour'
//  def hour_=(x: Int)     // setter for `hour'
//  def minute: Int        // getter for `minute'
//  def minute_=(x: Int)   // setter for `minute'
//}

//trait RationalTrait {
//  val numerArg: Int
//  val denomArg: Int
//}

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = numer + "/" + denom
}

class RationalClass(n: Int, d: Int) extends {
  val numerArg = n
  val denomArg = d
} with RationalTrait {
  def + (that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = numer + "/" + denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) = {}
}
class DogFood extends Food
class Dog extends Animal {
  type SuitableFood = DogFood
  override def eat(food: DogFood) = {}
}

object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

//object Direction extends Enumeration {
//  val North, East, South, West = Value
//}

object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}