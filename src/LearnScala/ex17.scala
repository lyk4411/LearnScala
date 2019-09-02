package LearnScala

import scala.collection.immutable.TreeMap
import scala.collection.mutable

/**
  * Created by lyk on 2019-9-2.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex17 {
  def countWords(text: String) = {
     val counts = mutable.Map.empty[String, Int]
     for (rawWord <- text.split("[ ,!.]+")) {
         val word = rawWord.toLowerCase
         val oldCount =
            if (counts.contains(word)) counts(word)
           else 0
         counts += (word -> (oldCount + 1))
       }
     counts
     }
  def longestWord(words: Array[String]) = {
    var word = words(0)
    var idx = 0
    for (i <- 1 until words.length)
      if (words(i).length > word.length) {
        word = words(i)
        idx = i
      }
    (word, idx)
  }

  def main(args: Array[String]) {
    val colors = List("red", "blue", "green")
    val fiveInts = new Array[Int](5)
    fiveInts.foreach(print)
    println()
    val fiveToOne = Array(5, 4, 3, 2, 1)
    fiveInts(0) = fiveToOne(4)
    fiveInts.foreach(print)
    println()
    val res1 = countWords("See Spot run! Run, Spot. Run!")
    println(res1)
    val ts = mutable.TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5, 9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
    println(ts)

    var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
    tm += (2 -> 'x')
    println(tm)
    println("longestWord(colors.toArray):" + longestWord(colors.toArray))
  }
}
