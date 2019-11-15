package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MaxConsecutiveOnes {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    nums
      .map(_.toString) // Turn numbers into digits.
      .mkString // Combine digits nto a string.
      .split("0") // Split on "0", returning a list of strings of 1s
      .map(_.size) // We only care about string lengths.
      .:+(0) // If input is [0], our list is now empty; append a 0.
      .max // Return the largest length.

  }
}
object MaxConsecutiveOnes {
  def main(args: Array[String]) {
    val a = new MaxConsecutiveOnes

  }
}
