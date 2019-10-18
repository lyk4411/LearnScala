package Leetcode

/**
  * Created by lyk on 2019-10-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class CountCompleteTreeNodes {
  def countNodes(root: TreeNode): Int = {
    if (root == null) 0 // if root node is null, the count of nodes is 0

    def calcNodes(cNode: TreeNode, nodeCount: Int = 0): Int = {
      if (cNode == null) return nodeCount // if we reach null, we got our nodeCount for this recursion step
      val leftSubtreeHeight = calculateSubtreeHeight(cNode.left) // get the height of left subtree
      val rightSubtreeHeight = calculateSubtreeHeight(cNode.right) // get the right of right subtree

      if (leftSubtreeHeight == rightSubtreeHeight) calcNodes(cNode.right, nodeCount + (1 << rightSubtreeHeight)) // calculateNodeCount, if right and left are equal, the tree is at least that tall, let's look for additional nodes on the left
      else calcNodes(cNode.left, nodeCount + (1 << rightSubtreeHeight)) // if they are not equal, the tree is at least that tall, let's look for additional nodes on the right subtree.
    }

    calcNodes(root) // start the recursion
  }

  private def calculateSubtreeHeight(cNode: TreeNode, height: Int = 0): Int = {
    if (cNode != null) calculateSubtreeHeight(cNode.left, height + 1)
    else height
  }
}
object CountCompleteTreeNodes {
  def main(args: Array[String]) {
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)
    val t5 = TreeNode(5)
    val t6 = TreeNode(6)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t3.left = t6
    val a = new CountCompleteTreeNodes
    println(a.countNodes(t1))
    println(a.countNodes(t5))
  }
}
