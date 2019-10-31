package Leetcode

/**
  * Created by lyk on 2019-10-31.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ValidSudoku {
//  def isValidSudoku(board: Array[Array[Char]]): Boolean = isValidRows(board) && isValidCols(board) && isValidSubBoxes(board)
//  def isValidRows(board: Array[Array[Char]]): Boolean = !board.exists(row => containsDuplicate(row.filter(_.isDigit)))
//  def isValidCols(board: Array[Array[Char]]): Boolean = isValidRows(board.transpose)
//  def isValidSubBoxes(board: Array[Array[Char]]): Boolean = {
//    !(0 until 3).exists(xMultiplier => {
//      val sliceFrom = xMultiplier * 3
//      val sliceUntil = sliceFrom + 3
//      (0 until 3).exists(yMultiplier => {
//        val subBox = board(yMultiplier * 3).slice(sliceFrom, sliceUntil) ++
//          board(yMultiplier * 3 + 1).slice(sliceFrom, sliceUntil) ++
//          board(yMultiplier * 3 + 2).slice(sliceFrom, sliceUntil)
//        containsDuplicate(subBox.filter(_.isDigit))
//      })
//    })
//  }
//  private def containsDuplicate[T](a: Array[T]): Boolean = {
//    val set = new scala.collection.mutable.HashSet[T]()
//    !a.forall(set.add)
//  }

  def initHM() = (0 to 8).map((_, scala.collection.mutable.Set.empty[Char])).toMap
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val rowHM = initHM()
    val colHM = initHM()
    val boxHM = initHM()
    (0 to 8).foreach { rowIdx =>
      (0 to 8).collect { case colIdx if board(rowIdx)(colIdx) != '.' =>
        val num = board(rowIdx)(colIdx)
        val boxNum = ((rowIdx / 3) * 3)  + ((colIdx) / 3)
        if (!rowHM(rowIdx).add(num) || !colHM(colIdx).add(num) || !boxHM(boxNum).add(num)) return false
      }
    }
    true
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
