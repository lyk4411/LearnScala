package Leetcode

/**
  * Created by lyk on 2019-10-29.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class UniqueBinarySearchTrees {
  def numTrees(n: Int): Int = {
    val counts = new Array[Int](n+1)
    counts(0) = 1
    counts(1) = 1
    for(total <- 2 to n){
      for (left <- 0 to total - 1) {
        val right = total - left - 1
        counts(total) += counts(left)*counts(right)
      }
    }
    counts(n)
  }

//  def numTrees(n: Int): Int = {
//    go(n, List(1))
//  }
//  private def go(n: Int, nums: List[Int]): Int = {
//    if (n == 0) nums.last else {
//      println(nums.zipWithIndex)
//      val num = nums.zipWithIndex.foldLeft(0)((acc, pair) => acc + pair._1 * nums(nums.length -1 - pair._2))
//      go(n - 1, nums :+ num)
//    }
//  }
}
object UniqueBinarySearchTrees {
  def main(args: Array[String]) {
    val a = new UniqueBinarySearchTrees
    println(a.numTrees(3))
  }
}
