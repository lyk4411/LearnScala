package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean =
    nums.distinct.size != nums.size
}
object ContainsDuplicate {
  def main(args: Array[String]) {
    val a = new ContainsDuplicate
    println(a.containsDuplicate(Array(1,2,3,1)))
    println(a.containsDuplicate(Array(1,2,3,4)))
  }
}

