package Leetcode
import scala.collection.immutable.HashMap

/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object LongestConsecutiveSequence {
  def longestConsecutive(nums: Array[Int]): Int = {
    val list = nums.toList
    def memoize[I, O](f: I => O): I => O = {
      var memo = new HashMap[I, O]()
      (k: I) => memo.getOrElse(k, {
        val v = f(k)
        memo += (k -> v)
        v
      })
    }
    val set = list.toSet
    lazy val maxSeq: Int => Int = memoize {
      case x if set contains (x + 1) => 1 + maxSeq(x + 1)
      case _ => 1
    }
    def iterate(acc: Int, xs: List[Int]): Int = xs match {
      case List() => acc
      case x :: xs1 => iterate( Math.max(maxSeq(x), acc), xs1)
    }
    iterate(0, list)
  }

  def main(args: Array[String]) {
    val a = Array(100, 4, 200, 1, 3, 2)
    println(1, longestConsecutive(a))
  }
}
