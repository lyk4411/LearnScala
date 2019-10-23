package Leetcode

/**
  * Created by lyk on 2019-10-23.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class CombinationSumIII {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val answers = scala.collection.mutable.Map[(Int, Int), List[List[Int]]]()
    answers ++= (1 to n).map(i => ((1, i), List(List(i)))).toMap
    println(answers)
    (2 to k).foreach(_k => {
      (1 to n).foreach(_n => {
        val all = (1 until _n).flatMap(m => {
          answers((_k - 1, m)).flatMap(ans => {
            if (ans.last < _n - m && _n - m < 10) {
              Some(ans :+ (_n - m))
            } else {
              None
            }
          })
        }).toList
        answers.put((_k, _n), all)
      })
    })
    return answers((k, n))
  }
}
object CombinationSumIII {
  def main(args: Array[String]) {
    val a = new CombinationSumIII
    println(a.combinationSum3(3, 7))
    println(a.combinationSum3(3, 9))
  }
}
