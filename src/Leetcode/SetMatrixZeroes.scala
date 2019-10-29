package Leetcode

/**
  * Created by lyk on 2019-10-29.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SetMatrixZeroes {
  def allZeros(m: Array[Array[Int]]): IndexedSeq[(Int, Int)] = {
    val r = m.length
    val c = m(0).length
    for {
      i <- 0 until r
      j <- 0 until c
      if m(i)(j) == 0
    } yield (i, j)
  }

  def setZeroes(m: Array[Array[Int]], zs: IndexedSeq[(Int, Int)]): Unit = {
    val r = m.length
    val c = m(0).length
    zs.foreach {
      case (i,j) => {
        m(i) = Array.fill(c)(0)
        (0 until r).foreach {
          case x => m(x)(j) = 0
        }
      }
    }
  }

  def setZeroes(matrix: Array[Array[Int]]): Unit =
    if (matrix.isEmpty) ()
    else {
      val zeros = allZeros(matrix)
      setZeroes(matrix, zeros)
    }
}

object SetMatrixZeroes {
  def main(args: Array[String]) {
    val a = new SetMatrixZeroes
    val mat = Array(Array(1,1,1),Array(1,0,1),Array(1,1,1))
    mat.toList.foreach(n => println(n.toList))
    a.setZeroes(mat)
    mat.toList.foreach(n => println(n.toList))
  }
}
