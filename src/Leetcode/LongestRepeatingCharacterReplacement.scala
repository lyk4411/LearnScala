package Leetcode

/**
  * Created by lyk on 2019-11-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class LongestRepeatingCharacterReplacement {
  def characterReplacement(s: String, k: Int): Int = {
    import collection.mutable.{Map, Queue}
    val q: Queue[Char] = Queue()
    val count: Map[Char, Int] = Map().withDefaultValue(0)
    var max = 0
    for {
      c <- s
    } {
      q.enqueue(c)
      count(c) += 1
      var needChange = q.length - (if(count.nonEmpty) {count.values.max} else {0})
      if(needChange > k) {
        count(q.dequeue()) -= 1
        needChange = q.length - (if(count.nonEmpty) {count.values.max} else {0})
      }
      max = Math.max(max, q.length)
    }
    max
  }
}
object LongestRepeatingCharacterReplacement {
  def main(args: Array[String]) {
    val a = new LongestRepeatingCharacterReplacement
    println(a.characterReplacement(s = "ABAB", k = 2))
    println(a.characterReplacement(s = "AABABBA", k = 1))
  }
}
