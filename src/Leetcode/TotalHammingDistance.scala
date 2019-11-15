package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class TotalHammingDistance {
  def totalHammingDistance(nums: Array[Int]): Int =
    (0 to 31)
      .map(i =>
        nums.fold(0)((b, c) => b + (c>>i & 1)))
      .fold(0)((d, f) => d + f*(nums.size-f))
}
object TotalHammingDistance {
  def main(args: Array[String]) {
    val a = new TotalHammingDistance
    println(a.totalHammingDistance(Array(4, 14, 2)))
  }
}
