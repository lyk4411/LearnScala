package Leetcode


/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class SortCharactersByFrequency {
//  def frequencySort(s: String): String = {
//    import collection.mutable.Map
//    val count: Map[Char, Int] = Map().withDefaultValue(0)
//    for {
//      c <- s
//    } {
//      count(c) += 1
//    }
//    count.toList.map(x => (x._2, x._1)).sorted.reverse.foreach(println)
//    count
//      .toList.map(x => (x._2, x._1))
//      .sorted
//      .reverse
//      .flatMap(x => List.fill(x._1)(x._2.toString))
//      .foldLeft("")(_ + _)
//  }
  import scala.collection.mutable
  def frequencySort(s: String): String = {
    if (s == null || s.length < 1) return s

    val map = mutable.Map[Char, Int]()
    for (c <- s) map.put(c, map.getOrElse(c, 0) + 1)

    map.toArray
      .sortWith((e1, e2) => e1._2 > e2._2) // order by cnt desc
      .map { case (c, cnt) => c.toString * cnt } // repeat char
      .mkString
  }
}
object SortCharactersByFrequency {
  def main(args: Array[String]) {
    val a = new SortCharactersByFrequency
    println(a.frequencySort("tree"))
    println(a.frequencySort("cccaaa"))
//    println(a.frequencySort("Aabb"))
//    println(a.frequencySort("abababababababababababbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"))
  }
}
