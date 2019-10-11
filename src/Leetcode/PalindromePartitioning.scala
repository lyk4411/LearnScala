package Leetcode

/**
  * Created by lyk on 2019-10-11.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class PalindromePartitioning {
  def partition(s: String): List[List[String]] = {
    partition(s, s.length - 1)
  }

  def partition(s: String, right: Int): List[List[String]] = {
    if (right < 0) List.empty
    else {
      val subString = s.substring(0, right + 1)

      if (isPalindrome(subString)) {
        val remaining: String = s.drop(subString.length)

        if (remaining != "") {
          partition(remaining).map(list => subString +: list) ++ partition(s, right - 1)
        } else {
          List(List(subString)) ++ partition(s, right - 1)
        }
      } else {
        partition(s, right - 1)
      }
    }
  }

  def isPalindrome(s: String): Boolean = {
    if (s.isEmpty) true
    else if (s.head != s.last) false
    else isPalindrome(s.drop(1).dropRight(1))
  }
}
object PalindromePartitioning {
  def main(args: Array[String]) {
    val a = new PalindromePartitioning
    println((a.partition("aab")))
  }
}
