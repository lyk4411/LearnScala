package Leetcode

import scala.collection.mutable

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class NextGreaterElementI {
  def nextGreaterElement(findNums: Array[Int], nums: Array[Int]): Array[Int] = {
    var map = Map.empty[Int, Int]
    val stack = mutable.Stack[Int]()
    var arr = Array.empty[Int]
    for (num <- nums) {
      while (stack.nonEmpty && num > stack.top) {
        map += stack.pop -> num
      }
      stack.push(num)
    }
    for (i <- findNums) {
      arr :+= map.getOrElse(i, -1)
    }
    arr
  }
}
object NextGreaterElementI {
  def main(args: Array[String]) {
    val a = new NextGreaterElementI
    a.nextGreaterElement(Array(4,1,2), Array(1,3,4,2)).foreach(n => print(n, " "))
    println
    a.nextGreaterElement(Array(2, 4), Array(1,2,3,4)).foreach(n => print(n, " "))
    println
    a.nextGreaterElement(Array(1,3,5,2,4), Array(6,5,4,3,2,1,7)).foreach(n => print(n, " "))
  }
}