package Leetcode

/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */

object MergeTwoSortedLists {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = (l1, l2) match {
    case (null,null)  => null
    case (null, l2) => l2
    case (l1, null) => l1
    case (l1, l2) if (l1.x <= l2.x) => {
      l1.next = mergeTwoLists(l1.next, l2)
      l1
    }
    case (l1, l2) if (l1.x > l2.x) => {
      l2.next = mergeTwoLists(l1, l2.next)
      l2
    }
  }

  def main(args: Array[String]) {
    var l1 = new ListNode(1)
    var l2 = new ListNode(2)
    var l3 = new ListNode(4)
    var r1 = new ListNode(1)
    var r2 = new ListNode(3)
    var r3 = new ListNode(4)
    l1.next = l2
    l2.next = l3
    r1.next = r2
    r2.next = r3
//    println(1, l1.x)
//    println(1, l1.next.x)
//    println(1, l1.next.next.x)
//    while (l1.next != null){
//      println(10, l1.x)
//      l1 = l1.next
//    }
//    println(10, l1.x)
//    println(1, l1.next.next.next.x)

    var result = mergeTwoLists(l1, r1)
    while (result.next != null){
      println(2, result.x)
      result = result.next
    }
    println(2, result.x)
  }
}
