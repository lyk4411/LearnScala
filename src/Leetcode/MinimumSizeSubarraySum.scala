package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MinimumSizeSubarraySum {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    val len = nums.length
    var i = 0
    var pre = -1
    var sum = 0
    var minLen = Int.MaxValue
    while (i < len && sum < s) {
      sum += nums(i)
      i += 1
    }
    if(i == len) {
      if(sum < s) return 0
    }
    minLen = i - 1 - pre
    pre += 1
    while(pre < len) {
      sum -= nums(pre)
      while (i < len && sum < s) {
        sum += nums(i)
        i += 1
      }
      if(sum >= s) {
        minLen = Math.min(minLen, i - 1 - pre)
      }
      pre += 1
    }
    minLen
  }
}
object MinimumSizeSubarraySum {
  def main(args: Array[String]) {
    val a = new MinimumSizeSubarraySum
    val s = 7
    val nums = Array(2,3,1,2,4,3)
    println(a.minSubArrayLen(s, nums))
  }
}
