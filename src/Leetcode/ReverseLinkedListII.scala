package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ReverseLinkedListII {
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      val dump = new ListNode(0)
      dump.next = head
      var prev = dump
      var p0 = head
      for (i <- 1 until m) {
        prev = p0
        p0 = p0.next
      }
      if (p0 == null) {
        return head
      }
      var p1 = p0.next
      var p2: ListNode = null
      (m until n).iterator.takeWhile(_ => p1 != null).foreach(_ => {
        p2 = p1.next
        p1.next = p0
        p0 = p1
        p1 = p2
      })
      prev.next.next = p1
      prev.next = p0
      dump.next
    }
  }
}
object ReverseLinkedListII {
  def main(args: Array[String]) {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    val a = new ReverseLinkedListII
    println(a.reverseBetween(l1, 2, 4))
  }
}
