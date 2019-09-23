package Leetcode


/**
  * Created by lyk on 2019-9-23.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object InvertBinaryTree {


  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) return root
    val node = TreeNode(root.value)
    node.left = invertTree(root.right)
    node.right = invertTree(root.left)
    node
  }
  def main(args: Array[String]) {
    var t1 = TreeNode(4)
    var t2 = TreeNode(2)
    var t3 = TreeNode(7)
    var t4 = TreeNode(1)
    var t5 = TreeNode(3)
    var t6 = TreeNode(6)
    var t7 = TreeNode(9)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t3.left = t6
    t3.right = t7
    println(t1)
    println(invertTree(t1))
  }

  case class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
    override def toString = {
      var toptree = value.toString + " "
      var lefttree = if(left != null) left.toString else " null "
      var righttree = if(right != null) right.toString else " null "
      toptree + lefttree + righttree
    }
  }

}