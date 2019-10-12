package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ContainsDuplicateII {
  def containsNearbyDuplicate(nums: Array[Int], maxDiff: Int): Boolean = {

    def existDiffWithinConstraint(indices: Array[Int]): Boolean =
      indices
        .sliding(2)
        .map {
          case Array(x, y) => y - x <= maxDiff
          case _ => false
        }.exists(identity)

    nums
      .zipWithIndex
      .groupBy(_._1) // use `HashMap` implicitly: value to indices map
      .values // already grouped, no longer need key (element value) parts
      .map(v => existDiffWithinConstraint(v.unzip._2))
      .exists(identity)
  }
}
object ContainsDuplicateII {
  def main(args: Array[String]) {
    val a = new ContainsDuplicateII
    println(a.containsNearbyDuplicate(Array(1,2,3,1),3))
    println(a.containsNearbyDuplicate(Array(1,2,3,1,2,3),2))
    println(a.containsNearbyDuplicate(Array(1,0,1,1),1))
  }
}

