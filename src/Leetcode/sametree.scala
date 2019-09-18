package Leetcode

/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object sametree {
  class TreeNode(var _value: Int) {
       var value: Int = _value
       var left: TreeNode = null
       var right: TreeNode = null
     }
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) return true
    if (p == null || q == null) return false

    p._value == q._value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }

  def main(args: Array[String]) {
    val t1 = new TreeNode(1)
    val t2 = new TreeNode(2)
    val t3 = new TreeNode(3)
    val tt1 = new TreeNode(1)
    val tt2 = new TreeNode(2)
    val tt3 = new TreeNode(3)
    t1.left = t2
    t1.right = t3
    tt1.left = tt2
    tt1.right = tt3
    println(1, isSameTree(t1, tt1))
    println(2, isSameTree(t2, tt2))
    println(3, isSameTree(t1, tt2))
  }
}
