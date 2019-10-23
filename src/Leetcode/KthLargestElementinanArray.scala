package Leetcode

/**
  * Created by lyk on 2019-10-23.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class KthLargestElementinanArray {
//  def findKthLargest(nums: Array[Int], k: Int): Int = {
//    var lowest = Int.MinValue
//    val pq = scala.collection.mutable.PriorityQueue.empty[Int](Ordering.by(_ * -1))
//    nums.foreach { num =>
//      if (lowest < num) pq.enqueue(num)
//      if (pq.size > k) lowest = pq.dequeue
//    }
//    pq.dequeue
//  }
    def findKthLargest(nums: Array[Int], k: Int): Int = {
      nums
        .drop(k)
        .foldLeft(nums.take(k).sorted)((sortedList, current) => {
          if (current > sortedList.head) (sortedList.drop(1) :+ current).sorted
          else sortedList
        })
        .head
    }
}
object KthLargestElementinanArray {
  def main(args: Array[String]) {
    val a = new KthLargestElementinanArray
    println(a.findKthLargest(Array(3,2,1,5,6,4), 2))
    println(a.findKthLargest(Array(3,2,3,1,2,4,5,5,6), 5))
  }
}
