package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class LongestIncreasingSubsequence {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val vc = Vector[Int](Int.MinValue)

    def lowerBound(v: Vector[Int], x: Int, lo: Int, hi: Int): Int = {
      if(lo + 1 == hi) return hi
      val mi = (lo + hi) /2
      if(v(mi) < x) lowerBound(v, x, mi, hi)
      else lowerBound(v, x, lo, mi)
    }

    nums.foldLeft(vc)((v, x) => {
      if(x > v.last) v :+ x
      else v.updated(lowerBound(v, x, 0, v.length), x)
    }).length - 1
  }
}
object LongestIncreasingSubsequence {
  def main(args: Array[String]) {
    val a = new LongestIncreasingSubsequence
    println(a.lengthOfLIS(Array(10,9,2,5,3,7,101,18)))
  }
}
