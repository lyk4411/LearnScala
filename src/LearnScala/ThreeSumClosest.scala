package LearnScala

/**
  * Created by lyk on 2019-11-1.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class ThreeSumClosest {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    require(nums.length >= 3)
    var best = nums.take(3).sum
    if (nums.length == 3) return best
    val arr = nums.sorted // Sort first since O(n log n) < O(n ^ 2)
    var anchor = 0
    while (anchor < arr.length - 2) {
      var l = anchor + 1
      var r = arr.length - 1
      while (l < r) {
        val sum = arr(anchor) + arr(l) + arr(r)
        // Update best
        if (math.abs(target - sum) < math.abs(target - best)){
          if (target == sum){
            return target
          }
          best = sum
        }
        if (sum <= target) { // Need more (use bigger numbers)
          while (l + 1 < r && arr(l) == arr(l + 1)) { // Scan over duplicates
            l += 1
          }
          l += 1
        }
        if (sum >= target) { // Need less (use smaller numbers)
          while (l < r - 1 && arr(r) == arr(r - 1)) { // Scan over duplicates
            r -= 1
          }
          r -= 1
        }
      }
      while (anchor + 1 < arr.length - 2 && arr(anchor) == arr(anchor + 1)) { // Scan over duplicates
        anchor += 1
      }
      anchor += 1
    }
    best
  }
}
