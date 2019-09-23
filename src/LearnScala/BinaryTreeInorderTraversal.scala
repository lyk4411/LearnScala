package LearnScala

/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
import collection.mutable.ListBuffer
//private case class TreeNode(var _value: Int) {
//  var value: Int = _value
//  var left: TreeNode = null
//  var right: TreeNode = null
//}
class BinaryTreeInorderTraversal {
  def inorderTraversal(root: TreeNode): List[Int] = {
    val res = ListBuffer[Int]()

    def inorder(root: TreeNode) : ListBuffer[Int] ={
      if (root == null) return res
      inorder(root.left)
      res += root.value
      inorder(root.right)
    }
    inorder(root).toList
  }
}
object BinaryTreeInorderTraversal{
  def main(args: Array[String]) {
    var t1 = TreeNode(1)
    var t2 = TreeNode(2)
    var t3 = TreeNode(3)
    t1.right = t2
    t2.left = t3
    val result = new BinaryTreeInorderTraversal
    println(result.inorderTraversal(t1))
  }
}
