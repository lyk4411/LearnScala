package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ReverseLinkedListII {
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    if (head == null || head.next == null || m == n) return head

    val dummyHead = new ListNode()
    dummyHead.next = head

    def locateFrontNode(): ListNode = {
      var ptr = dummyHead
      var step = 0
      for (step <- 0 to m - 2) {
        ptr = ptr.next
      }
      ptr
    }

    val front = locateFrontNode() // The mth node in list.
    val reversedTail = front.next // The tail node of reversed list.
    var toInsert = front.next.next // The next node to insert.

    for (i <- 0 to n - m - 1) {
      val nextToInsert = toInsert.next
      toInsert.next = front.next
      front.next = toInsert
      reversedTail.next = nextToInsert
      toInsert = nextToInsert
    }
    dummyHead.next
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
    println(a.reverseBetween(l1, 1, 4))
  }
}
