package Leetcode

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object LongestIncreasingPathinaMatrix {
  import scala.collection.mutable
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    if (matrix.length == 0)
       0
    else {
      val ms = matrix.length
      val ns = matrix(0).length
      val maxAtCoordinate: mutable.Map[(Int, Int), Int] = mutable.Map[(Int, Int), Int]()
      var max: Int = 1
      for (m <- 0 until ms) {
        for (n <- 0 until ns) {
          var len = dfs(matrix, m, n, ms, ns, maxAtCoordinate)
          max = Math.max(max, len)
        }
      }
      max
    }
  }

    def dfs(matrix: Array[Array[Int]], m:Int, n:Int, ms:Int, ns:Int, cache:mutable.Map[(Int, Int), Int]): Int ={
      val steps = Seq((-1, 0), (1, 0), (0, -1), (0, 1))
      if(cache.contains((m,n))) {
        cache((m, n))
      } else {
        var max: Int = 1
        for (step <- steps) {
          val x = m + step._1
          val y = n + step._2
          if (x >= 0 &&
            y >= 0 &&
            x < matrix.length &&
            y < matrix(m).length) {
            if (matrix(m)(n) < matrix(x)(y)) {
              val len = 1 + dfs(matrix, x, y, ms, ns, cache)
              max = Math.max(max, len)
            }
          }
        }
        cache((m, n)) = max
        max
      }
    }

//  import scala.collection.mutable
//  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
//    val maxAtCoordinate: mutable.Map[(Int, Int), Int] = mutable.Map[(Int, Int), Int]()
//
//    def longestIncreasingPath(row: Int, column: Int, previous: Int): Int = {
//      if (
//        row < 0 ||
//          column < 0 ||
//          row >= matrix.length ||
//          column >= matrix(row).length ||
//          previous >= matrix(row)(column)
//      ) 0
//      else {
//        maxAtCoordinate.getOrElse((row, column), {
//          val answers: Seq[Int] = for {
//            steps: (Int, Int) <- Seq(
//              (-1, 0),
//              (1, 0),
//              (0, -1),
//              (0, 1)
//            )
//            answer: Int = 1 + longestIncreasingPath(
//              row = row + steps._1,
//              column = column + steps._2,
//              previous = matrix(row)(column)
//            )
//          } yield answer
//
//          maxAtCoordinate((row, column)) = answers.max
//          maxAtCoordinate((row, column))
//        })
//      }
//    }
//
//    if (matrix.length == 0) 0
//    else {
//      val startingSpots: Seq[(Int, Int)] = for {
//        row <- matrix.indices
//        column <- matrix(row).indices
//      } yield (row, column)
//
//      startingSpots
//        .map(coordinates => {
//          longestIncreasingPath(
//            row = coordinates._1,
//            column = coordinates._2,
//            previous = Int.MinValue
//          )
//        })
//        .max
//    }
//  }

  def main(args: Array[String]) {
    val matrix1: Array[Array[Int]] = Array(Array(9,9,4),Array(6,6,8),Array(2,1,1))
    val matrix2: Array[Array[Int]] = Array(Array(3,4,5),Array(3,2,6),Array(2,2,1))
    val matrix3: Array[Array[Int]] = Array(Array(0,1,2,3,4,5,6,7,8,9),
                                            Array(19,18,17,16,15,14,13,12,11,10),
                                            Array(20,21,22,23,24,25,26,27,28,29),
                                            Array(39,38,37,36,35,34,33,32,31,30),
                                            Array(40,41,42,43,44,45,46,47,48,49),
                                            Array(59,58,57,56,55,54,53,52,51,50),
                                            Array(60,61,62,63,64,65,66,67,68,69),
                                            Array(79,78,77,76,75,74,73,72,71,70),
                                            Array(80,81,82,83,84,85,86,87,88,89),
                                            Array(99,98,97,96,95,94,93,92,91,90),
                                            Array(100,101,102,103,104,105,106,107,108,109),
                                            Array(119,118,117,116,115,114,113,112,111,110),
                                            Array(120,121,122,123,124,125,126,127,128,129),
                                            Array(139,138,137,136,135,134,133,132,131,130),
                                            Array(0,0,0,0,0,0,0,0,0,0))
    println(longestIncreasingPath(matrix1))
    println(longestIncreasingPath(matrix2))
    println(longestIncreasingPath(matrix3))
  }
}
