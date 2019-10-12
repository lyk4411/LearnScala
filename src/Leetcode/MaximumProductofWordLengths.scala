package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MaximumProductofWordLengths {
  def maxProduct(words: Array[String]): Int = {
    if (words == null || words.isEmpty) return 0

    // loop
    var res = 0
    val sets = words.map(_.toSet)
//    println(sets.toList)
//    println(words.indices)
//    println(words.length)
    for (i <- 0 until words.length)
      for (j <- i + 1 until words.length) {
        if ((sets(i) & sets(j)).isEmpty) {
          res = math.max(res, words(i).length * words(j).length)
        }
      }
    res
  }
}
object MaximumProductofWordLengths {
  def main(args: Array[String]) {
    val a = new MaximumProductofWordLengths
    println(a.maxProduct(Array("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
    println(a.maxProduct(Array("a", "ab", "abc", "d", "cd", "bcd", "abcd")))
    println(a.maxProduct(Array("a", "aa", "aaa", "aaaa")))
  }
}