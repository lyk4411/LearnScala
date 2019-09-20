package Leetcode

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
object NumberComplement {
  def findComplement(num: Int): Int = {
    Integer.parseInt((for (x<-Integer.toBinaryString(num)) yield '1'-x).mkString,2)
  }

  def main(args: Array[String]) {
    println(findComplement(5))
    println(findComplement(2))
  }
}
