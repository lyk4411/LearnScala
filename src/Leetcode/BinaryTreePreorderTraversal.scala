package Leetcode

/**
  * Created by lyk on 2019-10-11.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class BinaryTreePreorderTraversal {
  def preorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return List()
    val stack = scala.collection.mutable.Stack[TreeNode]()
    var res = scala.collection.mutable.ListBuffer[Int]()
    stack.push(root)
    while (stack nonEmpty) {
      val node = stack.pop
      if (node != null) {
        res += node.value
        stack.push(node.right)
        stack.push(node.left)
      }
    }
    res.toList
  }
}
object BinaryTreePreorderTraversal {
  def main(args: Array[String]) {
    val a = new BinaryTreePreorderTraversal
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    t1.right = t2
    t2.left = t3
    println(a.preorderTraversal(t1))
  }
}
