package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class UniqueSubstringsinWraparoundString {
  def findSubstringInWraproundString(p: String): Int = {
    val arr = Array.fill(26)(0)
    var maxLengthCur = 0
    for (i <- 0 until p.length){
      if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) maxLengthCur += 1
      else  maxLengthCur = 1
      val index = p.charAt(i) - 'a'
      arr(index) = Math.max(arr(index), maxLengthCur)
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