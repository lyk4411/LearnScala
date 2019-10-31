package Leetcode

/**
  * Created by lyk on 2019-10-31.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SortColors {
  def sortColors(nums: Array[Int]): Unit = {
    var ws = 0
    var bs = 0
    nums.indices.foreach(i => nums(i) match {
      case 0 =>
        nums(ws) = 0
        if (ws != bs) {
          nums(bs) = 1
        }
        if (bs != i) {
          nums(i) = 2
        }
        ws += 1
        bs += 1
      case 1 =>
        nums(bs) = 1
        if (bs != i) {
          nums(i) = 2
        }
        bs += 1
      case _ => // do nothing
    })
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
