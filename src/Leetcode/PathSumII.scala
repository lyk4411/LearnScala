package Leetcode

/**
  * Created by lyk on 2019-10-23.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class PathSumII {
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    if (root!=null && root.left==null && root.right==null && sum==root.value) return List(List(sum))
    if (root!=null && root.left==null && root.right==null && sum!=root.value) return List()
    if (root==null) return List()
    val childSum = sum - root.value
    val preLeftResult = pathSum(root.left,childSum)
    val preRightResult= pathSum(root.right,childSum)
    val preResult = preLeftResult:::preRightResult
    preResult.map(root.value::_)
  }
}
object PathSumII {
  def main(args: Array[String]) {
    val t1 = TreeNode(5)
    val t2 = TreeNode(4)
    val t3 = TreeNode(8)
    val t4 = TreeNode(11)
    val t5 = TreeNode(13)
    val t6 = TreeNode(4)
    val t7 = TreeNode(7)
    val t8 = TreeNode(2)
    val t9 = TreeNode(5)
    val t10 = TreeNode(1)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t3.left = t5
    t3.right = t6
    t4.left = t7
    t4.right = t8
    t6.left = t9
    t6.right = t10
    val a = new PathSumII
    println(a.pathSum(t1, 22))
//    println(List(List(1))::: List(List(2)) ::: List())
//    println(List()::: List()::: List())
//    println(List(List(1)).map(2::_))
//    println(List()::: List(List(1)))
  }
}
