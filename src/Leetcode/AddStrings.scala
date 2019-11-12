package Leetcode

/**
  * Created by lyk on 2019-11-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class AddStrings {
  def addStrings(num1: String, num2: String): String = {
    val mx = Math.max(num1.length, num2.length)
    val (big, small) = if (num1.length == mx) (num1, num2) else (num2, num1)
    val padSmall = "0" * (big.length - small.length) + small
    var carry = 0
    var result = ""
    for (idx <- big.length - 1 to 0 by -1){
      val total = big(idx).asDigit + padSmall(idx).asDigit + carry
      val num_to_add = total % 10
      carry = Math.floorDiv(total, 10)
      result = num_to_add + result
    }
    if (carry > 0) {
      result = carry.toString + result
    }
    result
  }
}
object AddStrings {
  def main(args: Array[String]) {
    val a = new AddStrings
    println(a.addStrings("123456", "9877"))
  }
}
