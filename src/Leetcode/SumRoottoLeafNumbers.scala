package Leetcode

/**
  * Created by lyk on 2019-10-11.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SumRoottoLeafNumbers {
  def sumNumbers(root: TreeNode): Int = {
    import scala.collection.mutable.ListBuffer
    def dfs(root: TreeNode, curVal: Int, ret: ListBuffer[Int]): Unit= {
      if (root == null) return

      val newVal = curVal * 10 + root.value
      if (root.left == null && root.right == null)
        ret += newVal

      dfs(root.left, newVal, ret)
      dfs(root.right, newVal, ret)
    }

    val ret = ListBuffer[Int]()
    dfs(root, 0, ret)
    ret.sum
  }
}
object SumRoottoLeafNumbers {
  def main(args: Array[String]) {
    val a = new SumRoottoLeafNumbers
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    t1.left = t2
    t1.right = t3
    println(a.sumNumbers(t1))
  }
}
