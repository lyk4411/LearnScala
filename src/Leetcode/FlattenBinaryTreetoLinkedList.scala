package Leetcode

/**
  * Created by lyk on 2019-9-27.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class FlattenBinaryTreetoLinkedList {
  def flatten(root: TreeNode): Unit = {
    if (root == null) null
    else if (root.left == null) flatten(root.right)
    else {
      val currentLeft = root.left
      val currentRight = root.right
      val greatestLeftNode: TreeNode = getMax(currentLeft)

      root.right = currentLeft
      root.left = null
      greatestLeftNode.right = currentRight
      flatten(currentLeft)
      flatten(currentRight)
    }
  }
  def getMax(root: TreeNode): TreeNode = {
    if (root.right == null) root
    else getMax(root.right)
  }
}
object FlattenBinaryTreetoLinkedList {
  def main(args: Array[String]) {
    val t1 = new TreeNode(1)
    val t2 = new TreeNode(2)
    val t3 = new TreeNode(3)
    val t4 = new TreeNode(4)
    val t5 = new TreeNode(5)
    val t6 = new TreeNode(6)
    t1.left = t2
    t1.right = t5
    t2.left = t3
    t2.right = t4
    t5.right = t6
    val a = new FlattenBinaryTreetoLinkedList
    println(a.flatten(t1))
  }
}
