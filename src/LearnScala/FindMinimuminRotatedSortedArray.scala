package LearnScala

/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object FindMinimuminRotatedSortedArray {
  def findMin(nums: Array[Int]): Int = {
//    if(nums == null || nums.length == 0)
//      return 0
//    if(nums.length == 1)
//      return nums(0)
//    var start:Int = 0
//    var end:Int = nums.length - 1
//    while(start < end){
//      var mid:Int = (start + end) / 2
//      if(mid > 0 && nums(mid) < nums(mid - 1)) {
//        return nums(mid)
//      }
//      if (nums(start) <= nums(mid) && nums(mid) > nums(end)) {
//        start = mid + 1;
//      } else {
//        end = mid - 1;
//      }
//    }
//    return nums(start);
    nums.min
  }

  def main(args: Array[String]) {
    println(findMin(Array(0,1,2,4,5,6,7)))
    println(findMin(Array(3,4,5,1,2)))
    println(findMin(Array(4,5,6,7,0,1,2)))
  }
}
