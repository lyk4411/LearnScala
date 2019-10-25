package Leetcode

/**
  * Created by lyk on 2019-10-25.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class Subsets {
//  def subsets(nums: Array[Int]): List[List[Int]] = {
//    nums.toSet.subsets.map(_.toList).toList
//  }

  def subsets(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) return List(List())
    val next = subsets(nums.tail)
    next ++ next.map(_ :+ nums.head)
  }
}
object Subsets {
  def main(args: Array[String]) {
    val a = new Subsets
    println(a.subsets(Array(1, 2, 3)))
  }
}
