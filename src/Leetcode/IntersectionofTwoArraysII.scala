package Leetcode

import scala.collection.mutable.ListBuffer

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object IntersectionofTwoArraysII {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var num1Map : Map[Int, Int] = nums1.groupBy(identity).mapValues(_.length)
    var r = new ListBuffer[Int]()
    nums2.foreach( n => {
      if(num1Map.contains(n) && num1Map(n) != 0){
        r += n
        num1Map = num1Map.updated(n,num1Map(n) - 1)
      }
    })
    r.toArray
  }

  def main(args: Array[String]) {
    val nums1:Array[Int] = Array(1,2,2,1)
    val nums2:Array[Int] = Array(2,2)
    println(intersect(nums1, nums2).toList)

    val nums3 = Array(4,9,5)
    val nums4 = Array(9,4,9,8,4)
    println(intersect(nums3, nums4).toList)

  }
}
