package Leetcode


/**
  * Created by lyk on 2019-10-11.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class BinaryTreeRightSideView {
  import scala.collection.mutable.ListBuffer
  def rightSideView(root: TreeNode): List[Int] = {
    val ans : ListBuffer[Int] = ListBuffer.empty
    helper(root, 1, ans)
    ans.toList
  }

  def helper(root: TreeNode, level: Int, ans: ListBuffer[Int]) : Unit = {
    if(root == null)
      return
    if(level > ans.size) {
      ans += root.value
    } else {
      ans(level-1) = root.value
    }
    helper(root.left, level + 1, ans)
    helper(root.right, level + 1, ans)
  }
}
object BinaryTreeRightSideView {
  def main(args: Array[String]) {
    val a = new BinaryTreeRightSideView
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
    println(a.rightSideView(t1))
  }
}
