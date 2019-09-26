package Leetcode

import scala.collection.mutable

/**
  * Created by lyk on 2019-9-26.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
  override def toString = {
    var b =  if(next != null) next.toString else " ."
    x.toString + "->" + b
  }
}
class MergekSortedLists {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val pq = mutable.PriorityQueue.empty[ListNode](Ordering.by(n => n.x)).reverse
    val dummyNode = new ListNode(0)
    var head = dummyNode

    //Insert the heads of all list nodes into the priorit yqueue
    lists.foreach(l => if(l!=null)pq.enqueue(l))
//    println(pq)
    while(!pq.isEmpty) {
      val node = pq.dequeue()
      head.next = new ListNode(node.x)
      if(node.next!=null)
        pq.enqueue(node.next)
      head = head.next
    }
    dummyNode.next
  }
}
object MergekSortedLists {
  def main(args: Array[String]) {
    var l1 = new ListNode(1)
    var l2 = new ListNode(4)
    var l3 = new ListNode(5)
    var l4 = new ListNode(1)
    var l5 = new ListNode(3)
    var l6 = new ListNode(4)
    var l7 = new ListNode(2)
    var l8 = new ListNode(6)
    l1.next = l2
    l2.next = l3
    l4.next = l5
    l5.next = l6
    l7.next = l8
    var b = Array(l7,l4,l1)
    var a = new MergekSortedLists
    println(a.mergeKLists(b))
  }
}
