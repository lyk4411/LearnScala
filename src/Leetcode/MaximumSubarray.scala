package Leetcode

/**
  * Created by lyk on 2019-8-24.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object MaximumSubarray {

  def maxSubArray(nums: Array[Int]): Int = {
    var max = nums(0)
    var curr = nums(0)
    for (i <- 1 until nums.length) {
      curr = Math.max(curr+nums(i), nums(i))
      max = Math.max(max, curr)
    }
    max
  }
  def main(args: Array[String]) {
    var myList = Array(-2, 1,-3,4,-1,2,1,-5,4)
    print(maxSubArray(myList))
  }
}
