package Leetcode

/**
  * Created by lyk on 2019-10-28.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    if (m <= 0 || n <= 0) {
      return 0
    }
    val rst = Array.fill[Int](m+1)(0)
    for (j <- 0 until n; i <- 1 to m) {
      if (j == 0 && i == 1) {
        rst(i) = 1
      } else {
        rst(i) = rst(i-1) + rst(i)
      }
    }
    return rst(m)
  }
}
object UniquePaths {
  def main(args: Array[String]) {
    val a = new UniquePaths
    println(a.uniquePaths(3, 2))
    println(a.uniquePaths(7, 3))
  }
}
