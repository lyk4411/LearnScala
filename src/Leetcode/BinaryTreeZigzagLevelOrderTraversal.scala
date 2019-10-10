package Leetcode

/**
  * Created by lyk on 2019-10-10.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class BinaryTreeZigzagLevelOrderTraversal {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    @annotation.tailrec
    def helper(current: List[TreeNode], res: List[List[Int]], leftToRight: Boolean): List[List[Int]] = {
      if (current.isEmpty) res
      else {
        val next = current.foldLeft(List.empty[TreeNode]) {
          case (list, node) =>
            if (node.left == null && node.right == null) list
            else if (node.left == null) node.right :: list
            else if (node.right == null) node.left :: list
            else if (leftToRight) node.right :: node.left :: list
            else node.left :: node.right :: list
        }

        helper(next, res :+ current.map(_.value), !leftToRight)
      }
    }

    val emptyList = List.empty[List[Int]]
    if (root == null) emptyList else helper(List(root), emptyList, true)
  }
}
object BinaryTreeZigzagLevelOrderTraversal {
  def main(args: Array[String]) {
    val a = new BinaryTreeZigzagLevelOrderTraversal
    val t1 = TreeNode(3)
    val t2 = TreeNode(9)
    val t3 = TreeNode(20)
    val t4 = TreeNode(15)
    val t5 = TreeNode(7)
    t1.left = t2
    t1.right = t3
    t3.left = t4
    t3.right = t5
    println(a.zigzagLevelOrder(t1))
  }
}
