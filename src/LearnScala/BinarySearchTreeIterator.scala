package LearnScala


import scala.collection.mutable

/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

case class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}
class BinarySearchTreeIterator(_root: TreeNode) {

  val stack = {
    val nodeStack = new mutable.Stack[TreeNode]()
    var ptr:TreeNode = _root
    while (ptr != null) {
      nodeStack.push(ptr)
      ptr = ptr.left
    }
    nodeStack
  }

  /** @return the next smallest number */
  def next(): Int = {
    var ptr = stack.pop()
    val nextSmallestVal = ptr.value

    if (ptr.right != null) {
      ptr = ptr.right
      while (ptr != null) {
        stack.push(ptr)
        ptr = ptr.left
      }
    }

    return nextSmallestVal
  }

  /** @return whether we have a next smallest number */
  def hasNext(): Boolean = {
    !stack.isEmpty
  }
}

object BinarySearchTreeIterator{

  def main(args: Array[String]) {
    var t1 = TreeNode(7)
    var t2 = TreeNode(3)
    var t3 = TreeNode(15)
    var t4 = TreeNode(9)
    var t5 = TreeNode(20)
    t1.left = t2
    t1.right = t3
    t3.left = t4
    t3.right = t5
    var result = new BinarySearchTreeIterator(t1)
    println(result.next())
    println(result.hasNext())
    println(result.next())
  }

}
