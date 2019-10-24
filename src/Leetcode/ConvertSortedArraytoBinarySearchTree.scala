package Leetcode

/**
  * Created by lyk on 2019-10-24.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ConvertSortedArraytoBinarySearchTree {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.isEmpty) null else {
      val center = math.floor(nums.size / 2).toInt
      val root = TreeNode(nums(center))
      root.left = sortedArrayToBST(nums.slice(0, center))
      root.right = sortedArrayToBST(nums.slice(center+1, nums.size))
      root
    }
  }
}
object ConvertSortedArraytoBinarySearchTree {
  def main(args: Array[String]) {
    val a = new ConvertSortedArraytoBinarySearchTree
    println(a.sortedArrayToBST(Array(-10,-3,0,5,9)))
  }
}
