package Leetcode

/**
  * Created by lyk on 2019-9-27.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class FlattenBinaryTreetoLinkedList {
  def flatten(root: TreeNode): Unit = {
    if (root == null) return;
    val res = preorderTraversal(root)
    var node = root;
    for (i <- 0 until res.length){
      node.value = res(i);
      node.left = null;
      if (i+1 < res.length) node.right = new TreeNode(0)
      node = node.right;
    }
  }
  def preorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return Nil
    List(root.value) ::: preorderTraversal(root.left) ::: preorderTraversal(root.right)
  }
}
object FlattenBinaryTreetoLinkedList {
  def main(args: Array[String]) {
    val t1 = new TreeNode(1)
    val t2 = new TreeNode(2)
    val t3 = new TreeNode(3)
    val t4 = new TreeNode(4)
    val t5 = new TreeNode(5)
    val t6 = new TreeNode(6)
    t1.left = t2
    t1.right = t5
    t2.left = t3
    t2.right = t4
    t5.right = t6
    val a = new FlattenBinaryTreetoLinkedList
    println(t1)
    a.flatten(t1)
    println(t1)
  }
}
