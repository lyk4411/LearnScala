package Leetcode

/**
  * Created by lyk on 2019-10-25.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class Combinations {
  def combine(n: Int, k: Int): List[List[Int]] = {
    (2 to k).foldLeft{
      (1 to n).toList.map(List(_))
    }{ (acc, _) =>
      acc.flatMap { list =>
        (1 to list.head - 1).map(_ +: list)
      }
    }
  }
}

object Combinations {
  def main(args: Array[String]) {
    val a = new Combinations
    println(a.combine(4, 1))
    println(a.combine(4, 2))
    println(a.combine(4, 3))
  }
}
