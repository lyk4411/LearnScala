package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class UniqueSubstringsinWraparoundString {
  def findSubstringInWraproundString(p: String): Int = {
    val arr = Array.fill(26)(0)
    var startI = 0
    var lastC = '0' //does not matter
    for (i <- 0 until p.length) {
      val c = p.charAt(i)
      if (i > 0 && (c - lastC == 1 || c - lastC == -25)) {
        for (j <- startI until i) {
          val id = p.charAt(j) - 'a'
          val len = i - j + 1
          if (arr(id) < len) arr(id) = len
        }
      }
      else {
        startI = i
      }
      if (arr(c - 'a') < 1) arr(c - 'a') = 1
      lastC = c
    }
    arr.sum
  }
}
object UniqueSubstringsinWraparoundString {
  def main(args: Array[String]) {
    val a = new UniqueSubstringsinWraparoundString
    println(a.findSubstringInWraproundString("a"))
    println(a.findSubstringInWraproundString("cac"))
    println(a.findSubstringInWraproundString("zab"))
  }
}