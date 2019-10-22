package Leetcode

/**
  * Created by lyk on 2019-10-22.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MajorityElement {
  def majorityElement(nums: Array[Int]): Int = {
    nums.groupBy(x => x).mapValues(_.size).maxBy(_._2)._1
  }
}
object MajorityElement {
  def main(args: Array[String]) {
    val a = new MajorityElement
    println(a.majorityElement(Array(3,2,3)))
    println(a.majorityElement(Array(2,2,1,1,1,2,2)))
  }
}
