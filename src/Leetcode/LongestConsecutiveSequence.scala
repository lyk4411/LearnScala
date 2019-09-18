package Leetcode
//import scala.collection.mutable.Set

/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object LongestConsecutiveSequence {
  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0)
      0
    var temp = nums.toSet

    var result = 0
    for (t <- temp) {
      if (temp contains t) {
        var l = t
        var sum = 1
        temp -= t

        while (temp contains (l - 1)) {
          temp -= (l - 1)
          l -= 1
        }
        sum += t - l
        var ll = t
        while (temp contains (ll + 1)) {
          temp -= (ll + 1)
          ll += 1
        }
        sum += ll - t
        result = Math.max(result, sum)
      }
    }
    result
  }
//    val list = nums.toList
//    def memoize[I, O](f: I => O): I => O = {
//      var memo = new HashMap[I, O]()
//      (k: I) => memo.getOrElse(k, {
//        val v = f(k)
//        memo += (k -> v)
//        v
//      })
//    }
//    val set = list.toSet
//    lazy val maxSeq: Int => Int = memoize ({
//      case x if set contains (x + 1) => 1 + maxSeq(x + 1)
//      case _ => 1
//    })
//    def iterate(acc: Int, xs: List[Int]): Int = xs match {
//      case List() => acc
//      case x :: xs1 => iterate( Math.max(maxSeq(x), acc), xs1)
//    }
//    iterate(0, list)
//  }

  def main(args: Array[String]) {
    val a1 = Array(100, 4, 200, 1, 3, 2)
    val a2 = Array(100, 4, 200, 1, 3, 2, 5, 5, 6)

    println(1, longestConsecutive(a1))
    println(2, longestConsecutive(a2))
  }
}
