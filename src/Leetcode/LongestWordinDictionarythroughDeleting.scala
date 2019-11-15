package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class LongestWordinDictionarythroughDeleting {
  def findLongestWord(s: String, d: List[String]): String = d
    .filter(w => w.length <= s.length && isGood(s, w, 0, 0)) match {
    case List() => ""
    case x => x.minBy(w => (-w.length, w))
  }

  private def isGood(s: String, w: String, i1: Int, i2: Int): Boolean ={
    if (i2==w.length)
      true
    else if (i1==s.length)
      false
    else if (s(i1) == w(i2))
      isGood(s, w, i1+1, i2+1)
    else
      isGood(s, w, i1+1, i2)
  }
}
object LongestWordinDictionarythroughDeleting {
  def main(args: Array[String]) {
    val a = new LongestWordinDictionarythroughDeleting
    println(a.findLongestWord(s = "abpcplea", d = List("ale","apple","monkey","plea")))
    println(a.findLongestWord(s = "abpcplea", d = List("a","b","c")))
  }
}