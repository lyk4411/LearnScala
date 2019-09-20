package Leetcode

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object KthSmallestElementinaSortedMatrix {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    import scala.collection.mutable
      val heap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()(Ordering.Int)
      for {
        i <- matrix.indices
        j <- matrix(i).indices
      } {
        heap.enqueue(matrix(i)(j))
        if (heap.length > k) heap.dequeue()
      }
      heap.dequeue()
    }

  def main(args: Array[String]) {
    val matrix:Array[Array[Int]] = Array(
      Array(1,5,9),
      Array(10,11,13),
      Array(12,13,15)
    )
    println(kthSmallest(matrix, 8))
  }
}
