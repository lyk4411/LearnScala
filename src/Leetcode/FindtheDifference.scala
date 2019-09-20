package Leetcode

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object FindtheDifference {
  def findTheDifference(s: String, t: String): Char = {
    (t diff s).head
  }

  def main(args: Array[String]) {
    println(findTheDifference("abcd","abcde"))
  }
}
