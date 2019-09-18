package Leetcode
import scala.collection.mutable.ListBuffer
/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object BinaryTreePostorderTraversal {
  class TreeNode(var _value: Int) {
       var value: Int = _value
       var left: TreeNode = null
       var right: TreeNode = null
     }
  def postorderTraversal(root: TreeNode): List[Int] = {
    val res = ListBuffer[Int]()
    helper(root, res)
    res.toList
  }

  def helper(node: TreeNode, res: ListBuffer[Int]): Unit = {
    if (node == null) return

    helper(node.left, res)
    helper(node.right, res)
    res.append(node.value)
  }

  def main(args: Array[String]) {
    val t1 = new TreeNode(3)
    val t2 = new TreeNode(9)
    val t3 = new TreeNode(20)
    val t4 = new TreeNode(15)
    val t5 = new TreeNode(7)
    t1.left = t2
    t1.right = t3
    t3.left = t4
    t3.right = t5
    var result = postorderTraversal(t1)
    println("result:", result)
  }
}
