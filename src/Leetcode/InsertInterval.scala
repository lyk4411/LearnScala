package Leetcode

/**
  * Created by lyk on 2019-9-24.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
case class Interval(var start:Int, var end:Int) {
      def Interval() { start = 0; end = 0; }
      def Interval(s : Int, e: Int) { start = s; end = e; }
  }
class InsertInterval {
  def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
    def helper(ivs: List[Interval],rst: List[Interval], newInterval: Interval): List[Interval] =
      ivs match {
        case head::tail => {
          if (newInterval.end < head.start) {
            helper(tail, rst:+newInterval, head)
          } else if (newInterval.start > head.end) {
            helper(tail, rst:+head, newInterval)
          } else {
            helper(tail, rst, Interval(Math.min(head.start, newInterval.start), Math.max(head.end, newInterval.end)))
          }
        }
        case tail => rst :+ newInterval
      }
    helper(intervals, List(), newInterval)
  }
}
object InsertInterval {
  def main(args: Array[String]) {
    var intervals = List(Interval(1, 3), Interval(6, 9))
    var newInterval = Interval(2, 5)
    var a = new InsertInterval
    var result = a.insert(intervals, newInterval)
    println(result)

    var intervals1 = List(Interval(1,2),Interval(3,5),
      Interval(6,7),Interval(8,10),Interval(12,16))
    var newInterval1 = Interval(4, 8)
    var a1 = new InsertInterval
    var result1 = a1.insert(intervals1, newInterval1)
    println(result1)
  }
}
