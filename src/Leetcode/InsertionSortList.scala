package Leetcode

/**
  * Created by lyk on 2019-10-23.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class InsertionSortList {
  def insertionSortList(head: ListNode): ListNode = {
    @annotation.tailrec
    def sort(sorted: ListNode, unsorted: ListNode): ListNode =
      unsorted match {
        case null => sorted
        case _ =>
          val (n, ns) = headTail(unsorted)
          sort(insert(sorted, n), ns)
      }
    def headTail(list: ListNode): (ListNode, ListNode) = {
      val hd = list
      val tl = list.next
      hd.next = null
      (hd, tl)
    }
    def insert(sorted: ListNode, node: ListNode): ListNode =
      sorted match {
        case null =>
          node
        case _ if node.x < sorted.x =>
          node.next = sorted
          node
        case _ =>
          val (n, ns) = headTail(sorted)
          n.next = insert(ns, node)
          n
      }
    sort(null, head)
  }
}
object InsertionSortList {
  def main(args: Array[String]) {
    val a = new InsertionSortList
    val l1= new ListNode(4)
    val l2= new ListNode(2)
    val l3= new ListNode(1)
    val l4= new ListNode(3)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    println(a.insertionSortList(l1))
  }
}
