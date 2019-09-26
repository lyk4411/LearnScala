package Leetcode

import scala.collection.mutable._
/**
  * Created by lyk on 2019-9-26.
  * Package name: Leetcode
  * Porject name: LearnScala
  */


class ReverseNodesinkGroup {
    def reverseKGroup(head: ListNode, k: Int): ListNode = {
      if (k < 2) return head // edge case

      val q = new Queue[Stack[Int]]
      var s = new Stack[Int] // max k length

      // build reverse order
      var currentNode = head
      while(currentNode != null) {
        s.push(currentNode.x)
        currentNode = currentNode.next
        if (s.length == k) {
          q.enqueue(s)
          s = new Stack[Int]
        }
      }

      currentNode = head
      s = new Stack[Int]
      while(q.nonEmpty || s.nonEmpty) {
        if (s.isEmpty) s = q.dequeue()
        currentNode.x = s.pop()
        currentNode = currentNode.next
      }

      head
    }
}
object ReverseNodesinkGroup {
  def main(args: Array[String]) {
    var a = new ReverseNodesinkGroup
    val l1 = new ListNode(1)
    val l2 = new ListNode(2)
    val l3 = new ListNode(3)
    val l4 = new ListNode(4)
    val l5 = new ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    println(a.reverseKGroup(l1, 2))
    println(a.reverseKGroup(l1, 3))
  }
}
