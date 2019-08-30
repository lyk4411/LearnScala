package Leetcode

/**
  * Created by lyk on 2019-8-24.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    def add(a: Int, b: Int): List[Int] =
      if (a + b > 9) List(1, 0)
      else List(0, a + b)

    digits
      .foldRight(List[Int]()) {
        case (e, acc) =>
          acc match {
            case x :: xs => add(x, e) ++ xs
            case Nil => add(e, 1)
          }
      }
      .dropWhile(_ == 0)
      .toArray
  }
  def main(args: Array[String]) {
    var myList = Array(4, 9, 9, 9)
    var myList1 = Array(9, 9, 9, 9)
    var a = for (x <- plusOne(myList)) yield x
    println("x:" + a.mkString(","))
    println()
    var b = for (x <- plusOne(myList1)) yield x
    println("x:" + b.mkString(","))

  }
}
