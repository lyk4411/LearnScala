package Leetcode

/**
  * Created by lyk on 2019-10-11.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SingleNumberII {
  def singleNumber(nums: Array[Int]): Int = {
    val once = scala.collection.mutable.Set.empty[Int]
    val multi = scala.collection.mutable.Set.empty[Int]

    nums.foreach { num =>
      (once(num), multi(num)) match {
        case (false, false) => once.add(num) // first time seen
        case (true, false) => // second time seen
          once.remove(num) // remove from once
          multi.add(num) // add to multi
        case (false, true) => () // do nothing already multi 2+ num
      }
    }
    once.head
  }
}
object SingleNumberII {
  def main(args: Array[String]) {
    val a = new SingleNumberII
    val nums1:Array[Int] = Array(2,2,3,2)
    println(a.singleNumber(nums1))
    println(a.singleNumber(Array(0,1,0,1,0,1,99)))
  }
}
