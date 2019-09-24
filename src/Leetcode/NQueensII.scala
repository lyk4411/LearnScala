package Leetcode

/**
  * Created by lyk on 2019-9-24.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class NQueensII {
  def totalNQueens(n: Int): Int = {
    queens(n).length
  }
  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = {
      if (k == 0) List(List())
      else
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
    }
    placeQueens(n)
  }
  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall(q => !inCheck(queen, q))
  def inCheck(queen1: (Int, Int), queen2: (Int, Int)) =
    queen1._1 == queen2._1  ||  //same row
      queen1._2 == queen2._2  ||  //same line
      (queen1._1 - queen2._1).abs == (queen1._2 - queen2._2).abs
}
object NQueensII {
  def main(args: Array[String]) {
    val a = new NQueensII
    println(a.totalNQueens(8))
    println(a.totalNQueens(4))
  }
}
