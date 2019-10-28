package Leetcode

/**
  * Created by lyk on 2019-10-28.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class RotateList {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    def helper(slow: ListNode, fast: ListNode, tail: ListNode, k: Int): ListNode = fast match {
      case node if node == tail => {val newHead = slow.next;slow.next = null;return newHead}
      case node if k != 0 => helper(slow, fast.next, tail, k-1)
      case node => helper(slow.next, fast.next, tail, k)
    }
    var tail = head
    var len = 1
    while (tail != null && tail.next != null) {
      tail = tail.next
      len += 1
    }
    if (tail == head || k%len == 0) {
      return head
    }
    tail.next = head
    helper(head, head, tail, k%len)
  }
}
object RotateList {
  def main(args: Array[String]) {
    val a = new RotateList
    val l1 = new ListNode(1)
    val l2 = new ListNode(2)
    val l3 = new ListNode(3)
    val l4 = new ListNode(4)
    val l5 = new ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    println(a.rotateRight(l1, 2))
  }
}
