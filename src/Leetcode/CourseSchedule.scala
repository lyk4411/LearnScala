package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class CourseSchedule {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    if (prerequisites.isEmpty) return true
    //Construct a in-degree map
    val inDegreeMap = prerequisites.foldLeft(Map[Int, Set[Int]]()) {
      case (acc, Array(source, dest)) => acc + (dest -> (acc.getOrElse(dest, Set()) + source)) + (source -> acc.getOrElse(source, Set()))
    }
    @scala.annotation.tailrec
    def tsort(inDegrees: Map[Int, Set[Int]]): Boolean = {
      val (zeroIns, nonZeroIns) = inDegrees.partition { _._2.isEmpty }
      (zeroIns.isEmpty, nonZeroIns.isEmpty) match {
        case (true, true) => true
        case (true, false) => false
        case _ => tsort(nonZeroIns.mapValues { _ -- zeroIns.keys })
      }
    }
    tsort(inDegreeMap)
  }
}
object CourseSchedule {
  def main(args: Array[String]) {
    val a = new CourseSchedule
    println(a.canFinish(2, Array(Array(1, 0))))
    println(a.canFinish(2, Array(Array(1, 0), Array(0, 1))))
  }
}
