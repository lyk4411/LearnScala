package LearnScala

/**
  * Created by lyk on 2019-9-12.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

class ex22 {
  def main(args: Array[String]) {
    val apples = new Apple :: Nil
    val fruits = new Orange :: apples
  }
  def incAll(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => x + 1 :: incAll(xs1)
  }
}

abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit
