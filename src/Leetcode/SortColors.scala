package Leetcode

/**
  * Created by lyk on 2019-10-31.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SortColors {
  def sortColors(nums: Array[Int]): Unit = {
    val numberMapping: Map[Int, Int] = nums.groupBy(identity).mapValues(_.length)
//    println(numberMapping)
    for (i <- 0 until numberMapping.getOrElse(0, 0)) nums(i) = 0
    for (i <- numberMapping.getOrElse(0, 0) until numberMapping.getOrElse(0, 0) + numberMapping.getOrElse(1, 0)) nums(i) = 1
    for (i <- numberMapping.getOrElse(0, 0) + numberMapping.getOrElse(1, 0) until nums.length) nums(i) = 2
  }
}
object SortColors {
  def main(args: Array[String]) {
    val a = new SortColors
    val b = Array(2,0,2,1,1,0)
    a.sortColors(b)
    b.foreach(print)
  }
}
