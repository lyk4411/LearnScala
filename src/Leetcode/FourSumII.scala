package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class FourSumII {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    val sumAB = for (a <- A; b <- B) yield (a + b)
//    sumAB.foreach(println)
//    sumAB.groupBy(r => r).values.foreach(n => println(n.toList))
    val sumToCntAB = sumAB.groupBy(r => r).map {
      case (s: Int, arr: Array[Int]) => (s, arr.size)
    }.toMap
//    println(sumToCntAB)
    val totalCnt = for (c <- C; d <- D) yield sumToCntAB.get(- c - d).getOrElse(0)
    return totalCnt.sum
  }
}
object FourSumII {
  def main(args: Array[String]) {
    val a = new FourSumII
    println(a.fourSumCount(
      Array(1, 2),Array(-2, -1),Array(-1, 2),Array(0, 2)))
  }
}
