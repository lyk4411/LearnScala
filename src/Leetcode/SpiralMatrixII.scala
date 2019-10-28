package Leetcode

/**
  * Created by lyk on 2019-10-28.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SpiralMatrixII {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    def helper(rst: List[List[Int]], index: Int): List[List[Int]] = index match {
      case i if i == 1 => rst
      case i => {
        val len = rst(0).length
        val list = List.range(i-len, i)
        i-len match {
          case k if k != 1 => helper((list :: rst).transpose.map(_.reverse), k)
          case k: Int => helper(list :: rst, k)
        }
      }
    }
    val rst = List(List(n*n))
    helper(rst, n*n).map(_.toArray) toArray
  }
}
object SpiralMatrixII {
  def main(args: Array[String]) {
    val a = new SpiralMatrixII
    a.generateMatrix(3).toList.foreach(n =>println(n.toList))
    a.generateMatrix(4).toList.foreach(n => println(n.toList))
  }
}
