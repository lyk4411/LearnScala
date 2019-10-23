package Leetcode

/**
  * Created by lyk on 2019-10-23.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SingleNumber {
  def singleNumber(nums: Array[Int]): Int = nums.groupBy(x => x).filter(_._2.length == 1).keys.head
}
object SingleNumber {
  def main(args: Array[String]) {
    val a = new SingleNumber
    println(a.singleNumber(Array(2,2,1)))
    println(a.singleNumber(Array(4,1,2,1,2)))
    println(Array(2,2,1).groupBy(x => x).values.toList)
    println(Array(2,2,1).groupBy(x => x).keys.toList)
  }
}
