package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class KthSmallestElementinaBST {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    def inOrderTraversal(root: TreeNode, count: Int): (Int, Option[Int]) = {
      if (root == null) (count, None)
      else {
        inOrderTraversal(root.left, count) match {
          case (0, Some(solution: Int)) =>
            (0, Some(solution))
          case (countRemaining: Int, None) if countRemaining == 1 =>
            (0, Some(root.value))
          case (countRemaining: Int, None) =>
            inOrderTraversal(root.right, countRemaining - 1)
        }
      }
    }
    inOrderTraversal(root, k)._2.get
  }
}
object KthSmallestElementinaBST {
  def main(args: Array[String]) {
    val a = new KthSmallestElementinaBST
    val t1 = TreeNode(3)
    val t2 = TreeNode(1)
    val t3 = TreeNode(4)
    val t4 = TreeNode(2)
    t1.left = t2
    t1.right = t3
    t2.right = t4
    println(a.kthSmallest(t1, 1))
    println(a.kthSmallest(t1, 2))

  }
}
