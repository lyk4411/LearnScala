package Leetcode

/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object RemoveDuplicatesfromSortedList {
  class ListNode(var _x: Int = 0) {
       var next: ListNode = null
       var x: Int = _x
     }
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      return head
    }
    head.next = deleteDuplicates(head.next)
    if (head.next != null && head.x == head.next.x) {
      head.next = head.next.next
    }
    head
  }

  def main(args: Array[String]) {
    val l1 = new ListNode(1)
    val l2 = new ListNode(2)
    val l3 = new ListNode(4)
    val l4 = new ListNode(4)
    val l5 = new ListNode(4)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5

    var result = deleteDuplicates(l1)
    while (result.next != null){
      println(1, result.x)
      result = result.next
    }
    println(1, result.x)
  }
}
