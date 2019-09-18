package Leetcode
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
/**
  * Created by lyk on 2019-9-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object BinaryTreeLevelOrderTraversal {
  class TreeNode(var _value: Int) {
       var value: Int = _value
       var left: TreeNode = null
       var right: TreeNode = null
     }

  def levelOrder(root: TreeNode): List[List[Int]] = {
    // Corner case.
    if (root == null) {
      return List()
    }

    val queue = new Queue[TreeNode]()
    val resultList = new ArrayBuffer[List[Int]]()  // List of values of treenodes in the final result.
    val levelList = new ArrayBuffer[Int]()  // List of values of treenodes within a level.

    // BFS level-order traversal.
    queue.enqueue(root)
    while (!queue.isEmpty) {
      val size = queue.size
      levelList.clear()
      for (i <- 1 to size) {
        val curNode = queue.dequeue()
        levelList.append(curNode.value)
        if (curNode.left != null)  queue.enqueue(curNode.left)
        if (curNode.right != null)  queue.enqueue(curNode.right)
      }
      resultList.append(levelList.toList)
    }

    resultList.toList
  }

  def main(args: Array[String]) {
    val t1 = new TreeNode(3)
    val t2 = new TreeNode(9)
    val t3 = new TreeNode(20)
    val t4 = new TreeNode(15)
    val t5 = new TreeNode(7)
    t1.left = t2
    t1.right = t3
    t3.left = t4
    t3.right = t5
    val result = levelOrder(t1)
    println("result:", result)
  }
}
