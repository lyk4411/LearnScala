package Leetcode

/**
  * Created by lyk on 2019-10-28.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    import scala.collection.mutable
    val map = mutable.Map.empty[(Int, Int), Int]
    def rec(m: Int, n: Int): Int = {
      if (map.get((m, n)).isDefined) {
        map((m, n))
      } else {
        if (m == 1)
          1
        else if (n == 1)
          1
        else {
          val c = rec(m - 1, n) + rec(m, n - 1)
          map += (((m, n), c))
          c
        }
      }
    }
    rec(m, n)
  }
}
object UniquePaths {
  def main(args: Array[String]) {
    val a = new UniquePaths
    println(a.uniquePaths(3, 2))
    println(a.uniquePaths(7, 3))
  }
}
