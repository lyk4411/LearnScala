package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class Powxn {
  def myPow(x: Double, n: Int): Double = {
    if (n == 0) return 1
    val temp = if(n == Int.MinValue) myPow(x, n >> 1) else if (n > 0) myPow(x, n/2) else return 1/myPow(x, -n)
    if (n % 2 == 0) temp * temp else x * temp * temp
  }
}
object Powxn {
  def main(args: Array[String]) {
    val a = new Powxn
    println(a.myPow(2, 10))
  }
}
