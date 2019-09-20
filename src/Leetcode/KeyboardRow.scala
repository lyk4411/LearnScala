package Leetcode

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object KeyboardRow {
  def findWords(arr: Array[String]): Array[String] = {
    val map: Map[Char, Char] = Map(
      'q' -> 'q', 'w' -> 'q', 'e' -> 'q', 'r' -> 'q', 't' -> 'q', 'y' -> 'q', 'u' -> 'q', 'i' -> 'q', 'o' -> 'q', 'p' -> 'q',
      'a' -> 'a', 's' -> 'a', 'd' -> 'a', 'f' -> 'a', 'g' -> 'a', 'h' -> 'a', 'j' -> 'a', 'k' -> 'a', 'l' -> 'a',
      'z' -> 'z', 'x' -> 'z', 'c' -> 'z', 'v' -> 'z', 'b' -> 'z', 'n' -> 'z', 'm' -> 'z')
    var set = Set.empty[Char]
    var answer = Array.empty[String]
    for (str <- arr) {
      set = Set.empty[Char]
      for (i <- str.toLowerCase; if set.size < 2) {
        set += map(i)
      }
      if (set.size < 2) answer :+= str
    }
    answer
  }

  def main(args: Array[String]) {
    println(findWords(Array("Hello", "Alaska", "Dad", "Peace")).toList)
  }
}
