package Leetcode

/**
  * Created by lyk on 2019-10-25.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class PartitionList {
  def partition(head: ListNode, x: Int): ListNode = {
    Option(head) match {
      case None => head
      case _ => {
        val ldump = new ListNode(0)
        val gdump = new ListNode(0)
        var lnext = ldump
        var gnext = gdump
        var nHead = head
        while (nHead != null) {
          if (nHead.x < x) {
            lnext.next = nHead
            lnext = nHead
          } else {
            gnext.next = nHead
            gnext = nHead
          }
          nHead = nHead.next
        }
        gnext.next = null
        lnext.next = gdump.next
        ldump.next
      }
    }
  }
}
object PartitionList {
  def main(args: Array[String]) {
    val a = new PartitionList
    val l1 = ListNode(1)
    val l2 = ListNode(4)
    val l3 = ListNode(3)
    val l4 = ListNode(2)
    val l5 = ListNode(5)
    val l6 = ListNode(2)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6
    println(a.partition(l1, 3))
  }
}
