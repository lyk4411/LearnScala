package Leetcode

/**
  * Created by lyk on 2019-10-29.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MergeIntervals {
  def merge(intervals: List[Interval]): List[Interval] =
    intervals.sortBy(_.start).foldLeft(List[Interval]()) {
      case (r::rs, i) if i.start <= r.end =>
        new Interval(r.start, i.end max r.end)::rs
      case (rs, i) => i::rs
    }

//  def merge(intervals: List[Interval]): List[Interval] = {
//    val sortedList = intervals.sortWith { _.start < _.start }
//    import scala.collection.mutable.ListBuffer
//    val res = ListBuffer[Interval]()
//
//    for (i <- sortedList) {
//      if (res.nonEmpty && i.start <= res.last.end)
//        res.last.end = math.max(i.end, res.last.end)
//      else
//        res += i
//    }
//    res.toList
//  }
}
object MergeIntervals {
  def main(args: Array[String]) {
    val a = new MergeIntervals
    println(a.merge(List(Interval(1,3),Interval(2,6),Interval(8,10),Interval(15,18))))
    val b = Array(Array(1,3),Array(2,6),Array(8,10),Array(15,18))
    val c = b.map(n => Interval(n(0),n(1))).toList
    println(a.merge(c))
    println(c.map(n => Array(n.start, n.end)).toArray)
  }
}
