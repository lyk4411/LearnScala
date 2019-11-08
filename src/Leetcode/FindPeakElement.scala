package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class FindPeakElement {
  def findPeakElement(nums: Array[Int]): Int = {
    var index = 0
    var max = nums(0)
    for(i <- 1 to nums.length - 2){
      var prev = nums(i-1)
      var curr = nums(i)
      var next = nums(i+1)
      if(curr > prev && curr > next && curr > max){
        index = i
        max = curr
      }
    }
    if(nums(nums.length-1) > max){
      return nums.length-1;
    }
    return index;
  }
}
object FindPeakElement{
  def main(args: Array[String]) {
    val a = new FindPeakElement
    println(a.findPeakElement(Array(1,2,3,1)))
    println(a.findPeakElement(Array(1,2,3)))
    println(a.findPeakElement(Array(1,2,3,4)))
    println(a.findPeakElement(Array(1,2,1,3,5,6,4)))
  }
}
