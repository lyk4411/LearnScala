package Leetcode

/**
  * Created by lyk on 2019-10-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class LargestNumber {
  def largestNumber(nums: Array[Int]): String = {
    BigInt(nums.map(_.toString).sortWith((l, r) => l ++ r >= r ++ l).foldLeft("")(_ + _)).toString
  }
}
object LargestNumber {
  def main(args: Array[String]) {
    val a = new LargestNumber
    println(a.largestNumber(Array(10, 2)))
    println(a.largestNumber(Array(3, 30, 34, 5, 9)))
  }
}
