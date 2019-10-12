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

//    println(nums.zipWithIndex.toList)
//    nums.zipWithIndex.groupBy(_._1).foreach(n => println(n._2.toList))
//    nums.zipWithIndex.groupBy(_._1).values.foreach(n => println(n.toList))
//    nums.zipWithIndex.groupBy(_._1).values.map(v => v.unzip).foreach(x => println(x._1.toList, x._2.toList))
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
//    println(a.containsNearbyDuplicate(Array(1,2,3,1,2,3),2))
//    println(a.containsNearbyDuplicate(Array(1,0,1,1),1))
  }
}

