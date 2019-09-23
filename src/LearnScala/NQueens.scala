package LearnScala

/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class NQueens {
  def solveNQueens(n: Int): List[List[String]] = {
    generateBoard(queens(n), n)
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

  def generateBoard(lists: List[List[(Int, Int)]], n: Int): List[List[String]] = {
    var res: List[List[String]] = List.empty[List[String]]
    for (queens <- lists) {
      val board = new Array[Array[Char]](n)
      for (i <- 0 until  n) {
        board(i) = new Array[Char](n)
        for (j <- 0 until n)
          board(i)(j) = '.'
      }
      queens.foreach(q => board(q._1 - 1)(q._2 - 1)='Q')
      val queensStr: List[String] = board.map(row => String.valueOf(row)).toList
      res = queensStr :: res
    }
    res
  }
}
object NQueens{
  def main(args: Array[String]) {
    val result = new NQueens
    val q8 = result.solveNQueens(8)
    for(ts <- q8) {
      for (t <- ts) {
        println(t)
      }
      println("=============================")
    }
  }
}