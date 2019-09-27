package Leetcode

/**
  * Created by lyk on 2019-9-26.
  * Package name: Leetcode
  * Porject name: LearnScala
  */

case class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  override def toString = {
    var l = new String
    var r = new String
    if(left != null) {l = left.toString} else { l = " # "}
    if(right != null) {r = right.toString} else { r = " # "}
    value.toString + l + r
  }
}
class BinaryTreeMaximumPathSum {
  var maxSum: Int = _

  def maxPathSum(root: TreeNode): Int = {
    maxSum = root.value
    getDownwardPathSum(root)
    maxSum
  }

  def getDownwardPathSum(node: TreeNode): Int = {
    if (node == null) return 0

    val leftSum = Math.max(0, getDownwardPathSum(node.left))
    val rightSum = Math.max(0, getDownwardPathSum(node.right))
    // Update maxSum if needed.
    maxSum = Math.max(maxSum, leftSum + rightSum + node.value)

    Math.max(leftSum, rightSum) + node.value
  }
}
object BinaryTreeMaximumPathSum {
  def main(args: Array[String]) {
    val a = new BinaryTreeMaximumPathSum
    val t1 = new TreeNode(1)
    val t2 = new TreeNode(2)
    val t3 = new TreeNode(3)

    val t4 = new TreeNode(-10)
    val t5 = new TreeNode(9)
    val t6 = new TreeNode(20)
    val t7 = new TreeNode(15)
    val t8 = new TreeNode(7)
    t1.left = t2
    t1.right = t3
    t4.left = t5
    t4.right = t6
    t6.left = t7
    t6.right = t8
    println(a.maxPathSum(t1))
    println(a.maxPathSum(t4))
  }
}
