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
//        println("current: ", current)
        val next = current.foldLeft(List.empty[TreeNode]) {
          case (list, node) =>
//            println("list:", list, "  node:", node.value)
            if (node.left == null && node.right == null) list
            else if (node.left == null) node.right :: list
            else if (node.right == null) node.left :: list
            else if (leftToRight) node.right :: node.left :: list
            else node.left :: node.right :: list
        }
//        println("result of next:", next, " result of res:", res :+ current.map(_.value))
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
    val t6 = TreeNode(6)
    val t7 = TreeNode(8)
    val t8 = TreeNode(38)
    val t9 = TreeNode(39)
    val t10 = TreeNode(40)
    val t11 = TreeNode(41)

    t1.left = t2
    t1.right = t3
    t3.left = t4
    t3.right = t5
    t2.left = t6
    t2.right = t7
    t6.left = t8
    t6.right = t9
    t7.left = t10
    t7.right = t11
    println(a.zigzagLevelOrder(t1))
  }
}
