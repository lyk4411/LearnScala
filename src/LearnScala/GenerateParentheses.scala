package LearnScala

/**
  * Created by lyk on 2019-11-1.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class GenerateParentheses {
  def generateParenthesis(n: Int): List[String] = {
    val seq = new Array[Char](n * 2)
    val arr = scala.collection.mutable.ListBuffer.empty[String]

    def genParens(seq: Array[Char], idx: Int, leftParens: Int, rightParens: Int): Unit = {
      if (leftParens >= 0 && rightParens >= 0 && leftParens <= rightParens) {
        if (leftParens == 0 && rightParens == 0) {
          arr += seq.mkString
        }
        else {
          if (leftParens > 0) {
            seq(idx) = '('
            genParens(seq, idx + 1, leftParens - 1, rightParens)
          }

          if (rightParens > 0) {
            seq(idx) = ')'
            genParens(seq, idx + 1, leftParens, rightParens - 1)
          }
        }
      }
    }

    genParens(seq, 0, n, n)
    arr.toList
  }
}
object GenerateParentheses {
  def main(args: Array[String]) {
    val a = new GenerateParentheses
    println(a.generateParenthesis(2))
    println(a.generateParenthesis(3))
    println(a.generateParenthesis(4))
  }
}
