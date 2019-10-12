package Leetcode

/**
  * Created by lyk on 2019-10-11.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class PalindromePartitioning {
  def partition(s: String): List[List[String]] = {
    help(s, s.length - 1)
  }

  def help(s: String, right: Int): List[List[String]] = {
    if (right < 0) List.empty
    else {
      val subString = s.substring(0, right + 1)

      if (isPalindrome(subString)) {
        val remaining: String = s.drop(subString.length)
//        println("s", s)

        if (remaining != "") {
          partition(remaining).map(list => subString +: list) ++ help(s, right - 1)
        } else {
          List(List(subString)) ++ help(s, right - 1)
        }
      } else {
        help(s, right - 1)
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
    println((a.partition("aaab")))
    println((a.partition("abb")))

    //    println(List(List(4,5,6)) ++ List(List(1,2,3)))
  }
}
