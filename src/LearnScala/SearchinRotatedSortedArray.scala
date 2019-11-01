package LearnScala

/**
  * Created by lyk on 2019-11-1.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class SearchinRotatedSortedArray {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) -1 else search(nums, target, 0, nums.length - 1)
  }

  def search(nums: Array[Int], target: Int, l: Int, r: Int): Int = {
    if (l > r) -1 else {
      val m = (l + r) / 2
      if (nums(m) == target) m else if (nums(l) <= nums(m) && include(target, nums(l), nums(m)) ||
        nums(m) <= nums(r) && !include(target, nums(m), nums(r))
      ) {
        search(nums, target, l, m - 1)
      } else search(nums, target, m + 1, r)
    }
  }
  def include(target: Int, l: Int, r: Int): Boolean = l <= target && target <= r
}
object SearchinRotatedSortedArray {
  def main(args: Array[String]) {
    val a = new SearchinRotatedSortedArray
    println(a.search(nums = Array(4,5,6,7,0,1,2), target = 0))
    println(a.search(nums = Array(4,5,6,7,0,1,2), target = 3))

  }
}