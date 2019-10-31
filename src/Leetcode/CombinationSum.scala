package Leetcode

/**
  * Created by lyk on 2019-10-31.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class CombinationSum {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    def combAcc(nums: List[Int], left: Int, acc: List[Int]): List[List[Int]] =
      if (left < 0) Nil
      else if (left == 0) List(acc)
      else {
        nums match {
          case Nil => Nil
          case x :: xs => combAcc(x :: xs, left - x, x :: acc) ::: combAcc(xs, left, acc)
        }
      }
    combAcc(candidates.toList, target, Nil)
  }
}
object CombinationSum {
  def main(args: Array[String]) {
    val a = new CombinationSum
    println(a.combinationSum(candidates = Array(2,3,6,7), target = 7))
    println(a.combinationSum(candidates = Array(2,3,5), target = 8))
  }
}
