package Leetcode

/**
  * Created by lyk on 2019-10-31.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ValidSudoku {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = isValidRows(board) && isValidCols(board) && isValidSubBoxes(board)
  def isValidRows(board: Array[Array[Char]]): Boolean = !board.exists(row => containsDuplicate(row.filter(_.isDigit)))
  def isValidCols(board: Array[Array[Char]]): Boolean = isValidRows(board.transpose)
  def isValidSubBoxes(board: Array[Array[Char]]): Boolean = {
    !(0 until 3).exists(xMultiplier => {
      val sliceFrom = xMultiplier * 3
      val sliceUntil = sliceFrom + 3
      (0 until 3).exists(yMultiplier => {
        val subBox = board(yMultiplier * 3).slice(sliceFrom, sliceUntil) ++
          board(yMultiplier * 3 + 1).slice(sliceFrom, sliceUntil) ++
          board(yMultiplier * 3 + 2).slice(sliceFrom, sliceUntil)
        containsDuplicate(subBox.filter(_.isDigit))
      })
    })
  }
  private def containsDuplicate[T](a: Array[T]): Boolean = {
    val set = new scala.collection.mutable.HashSet[T]()
    !a.forall(set.add)
  }
}
object ValidSudoku {
  def main(args: Array[String]) {
    val a = new ValidSudoku
    println(a.isValidSudoku(Array(
        Array('5','3','.','.','7','.','.','.','.'),
        Array('6','.','.','1','9','5','.','.','.'),
        Array('.','9','8','.','.','.','.','6','.'),
        Array('8','.','.','.','6','.','.','.','3'),
        Array('4','.','.','8','.','3','.','.','1'),
        Array('7','.','.','.','2','.','.','.','6'),
        Array('.','6','.','.','.','.','2','8','.'),
        Array('.','.','.','4','1','9','.','.','5'),
        Array('.','.','.','.','8','.','.','7','9'))))

    println(a.isValidSudoku(Array(
        Array('8','3','.','.','7','.','.','.','.'),
        Array('6','.','.','1','9','5','.','.','.'),
        Array('.','9','8','.','.','.','.','6','.'),
        Array('8','.','.','.','6','.','.','.','3'),
        Array('4','.','.','8','.','3','.','.','1'),
        Array('7','.','.','.','2','.','.','.','6'),
        Array('.','6','.','.','.','.','2','8','.'),
        Array('.','.','.','4','1','9','.','.','5'),
        Array('.','.','.','.','8','.','.','7','9'))))
  }
}
