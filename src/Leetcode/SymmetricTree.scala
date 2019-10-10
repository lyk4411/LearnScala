package Leetcode

/**
  * Created by lyk on 2019-10-10.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SymmetricTree {
  def pairIsSynched(root: TreeNode, reflection: TreeNode): Boolean =
    (Option(root), Option(reflection)) match {
      case (None, Some(_)) | (Some(_), None) =>
        false
      case (None, None) =>
        true
      case (Some(root), Some(reflection)) =>
        Seq(
          root.value == reflection.value,
          pairIsSynched(root.left, reflection.right),
          pairIsSynched(root.right, reflection.left)
        ).reduce(_ && _)
    }

  def isSymmetric(root: TreeNode): Boolean =
    Option(root) match {
      case None =>
        true
      case Some(root) =>
        pairIsSynched(root.left, root.right)
    }
}
object SymmetricTree {
  def main(args: Array[String]) {
    val a = new SymmetricTree
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(2)
    val t4 = TreeNode(3)
    val t5 = TreeNode(4)
    val t6 = TreeNode(4)
    val t7 = TreeNode(3)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t3.left = t6
    t3.right = t7
    println(a.isSymmetric(t1))
    println(a.isSymmetric(t2))
  }
}
