package Leetcode

/**
  * Created by lyk on 2019-10-25.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class WordSearch {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    for {
      i <- 0 to board.length
      j <- 0 to board(0).length
    } yield {
      if (exists(board, i, j, word, 0)) return true
    }
    false
  }

  def exists(board: Array[Array[Char]], i: Int, j: Int, word: String, wIndex: Int): Boolean = {
    if (wIndex == word.length) return true
    if (i < 0 || j < 0 || (i == board.length) || (j == board(i).length)) return false
    if (board(i)(j) != word(wIndex)) return false
    val temp = board(i)(j)
    board(i)(j) = '.'
    val nextWIndex = wIndex + 1
    val wordExists =
      exists(board, i, j + 1, word, nextWIndex) ||
        exists(board, i, j - 1, word, nextWIndex) ||
        exists(board, i + 1, j, word, nextWIndex) ||
        exists(board, i - 1, j, word, nextWIndex)
    board(i)(j) = temp
    wordExists
  }
}
object WordSearch {
  def main(args: Array[String]) {
    val board: Array[Array[Char]] =
      Array(Array('A','B','C','E'),Array('S','F','C','S'),Array('A','D','E','E'))
    val a = new WordSearch
    println(a.exist(board, "ABCCED"))
    println(a.exist(board, "SEE"))
    println(a.exist(board, "ABCB"))
  }
}
