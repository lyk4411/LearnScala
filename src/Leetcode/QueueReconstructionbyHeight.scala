package Leetcode

import java.io.Serializable

/**
  * Created by lyk on 2019-11-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class QueueReconstructionbyHeight {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    if(people.length == 0) return people
    val pp = people.sortBy(n => (-n(0),n(1)))
    var result:List[Any] = List()
    for(i <- 0 until pp.length ) {
      val temp = result.splitAt(pp(i)(1) * 2)
      result = temp._1 ++ pp(i) ++ temp._2
    }
    var resultarray = result.toArray
    var r : Array[Array[Int]] = new Array[Array[Int]](people.length)
    for(i <- 0 until people.length){
      val t = new Array[Int](2)
      t(0) = resultarray(i * 2).toString.toInt
      t(1) = resultarray(i * 2 + 1).toString.toInt
      r(i) = t
   }
    r
  }
}
object QueueReconstructionbyHeight {
  def main(args: Array[String]) {
    val a = new QueueReconstructionbyHeight
    a.reconstructQueue(
      Array(Array(7,0), Array(4,4), Array(7,1), Array(5,0), Array(6,1), Array(5,2))).
      foreach(n => println(n.toList))
  }
}
