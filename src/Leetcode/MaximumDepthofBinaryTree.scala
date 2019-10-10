package Leetcode

/**
  * Created by lyk on 2019-10-10.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MaximumDepthofBinaryTree {
  def maxDepth(root: TreeNode): Int =
    Option(root) match {
      case Some(root) =>
        (Option(root.left), Option(root.right)) match {
          case (None,       None       ) => 1
          case (Some(left), None       ) => 1 + maxDepth(left)
          case (None,       Some(right)) => 1 + maxDepth(right)
          case (Some(left), Some(right)) => 1 + Math.max(maxDepth(left), maxDepth(right))
        }
      case _ =>
        0
    }
}
object MaximumDepthofBinaryTree {
  def main(args: Array[String]) {
    val a = new MaximumDepthofBinaryTree
    val t1 = TreeNode(3)
    val t2 = TreeNode(9)
    val t3 = TreeNode(20)
    val t4 = TreeNode(15)
    val t5 = TreeNode(7)
    t1.left = t2
    t1.right = t3
    t3.left = t4
    t4.right = t5
    print(a.maxDepth(t1))
    print(a.maxDepth(t3))
  }
}
