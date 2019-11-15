package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MinimumMovestoEqualArrayElementsII {
  def minMoves2(nums: Array[Int]): Int = {
    val median = nums.sortWith(_ < _)(nums.length / 2)
    nums.foldLeft(0)((a, c) => a + math.abs(median - c))
  }
}
object MinimumMovestoEqualArrayElementsII {
  def main(args: Array[String]) {
    val a = new MinimumMovestoEqualArrayElementsII
    println(a.minMoves2(Array(1,2,3)))
    println(a.minMoves2(Array(1,2,3,4)))
  }
}
