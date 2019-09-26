package Leetcode

/**
  * Created by lyk on 2019-9-26.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MedianofTwoSortedArrays {
//  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
//    val a = (nums1 ++ nums2).sorted
//    val n = a.length
//
//    n match {
//      case 1 => a(0)
//      case _ =>
//        if(n%2 == 0) {
//          val mid = n / 2
//          (a(mid) + a(mid - 1)) / 2.0
//        }
//        else
//          a(n/2)
//    }
//  }
def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
  findR(nums1.toList, nums2.toList)
}

  def findR(n1: List[Int], n2: List[Int]): Double = (n1, n2) match {
    //Base cases
    case (Nil, h2 :: Nil) => h2 // Only single element left in l2
    case (h1 :: Nil, Nil) => h1 // Only Single element left in l1
    case (h1 :: Nil, h2 :: Nil) => (h1 + h2) / 2.0 // Two elements remain, one in each
    case (fst :: snd :: Nil, Nil) => (fst + snd) / 2.0 //Two elements remain, all in l1
    case (Nil, fst :: snd :: Nil) => (fst + snd) / 2.0 //Two elements remain, all in l2

    //Recursive Case
    //More than 2 elements total, drop biggest and smallest element
    case (Nil, l2) => findR(Nil, l2.dropRight(1).drop(1)) //l1 is empty
    case (l1, Nil) => findR(Nil, l1.dropRight(1).drop(1)) //l2 is empty
    case (l1, l2) => { //Elements left in both
      if(l1.head < l2.head) { //l1 has smallest element
        if(l1.last > l2.last) { //l1 has biggest elemnt
          findR(l1.drop(1).dropRight(1), l2)
        } else { //l2 has biggest element
          findR(l1.drop(1), l2.dropRight(1))
        }
      } else { //l2 has smallest element
        if(l1.last > l2.last) { //l1 has biggest ehelemnt
          findR(l1.dropRight(1), l2.drop(1))
        } else { //l2 has biggest element
          findR(l1, l2.drop(1).dropRight(1))
        }
      }
    }
  }
}
object MedianofTwoSortedArrays {
  def main(args: Array[String]) {
    var nums1 = Array(1, 3)
    var nums2 = Array(2)
    var nums3 = Array(1, 2)
    var nums4 = Array(3, 4)
    var a = new MedianofTwoSortedArrays
    println(a.findMedianSortedArrays(nums1, nums2))
    println(a.findMedianSortedArrays(nums3, nums4))
  }
}
