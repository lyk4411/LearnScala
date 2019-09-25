package Leetcode

import scala.collection.mutable

/**
  * Created by lyk on 2019-9-25.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class TrappingRainWater {
  def trap(height: Array[Int]): Int = {
    val stack = new mutable.Stack[Int]()
    var waterTrapped = 0

    for (i <- 0 to height.size - 1) {
      while (!stack.isEmpty && height(i) > height(stack.top)) { // With water trapped.
        val bottomHeight = height(stack.pop())
          if (!stack.isEmpty) {
            val leftHeight = height(stack.top)
            val width = i - stack.top - 1
            waterTrapped += width * (Math.min(leftHeight, height(i)) - bottomHeight)
          }
      }
      stack.push(i)
    }
    waterTrapped
  }

//  def trap(height: Array[Int]): Int =
//    height.scan(0)(_ max _).drop(1)
//      .zip(height.scanRight(0)(_ max _).dropRight(1))
//      .map(Function.tupled(_ min _)).sum - height.sum
}
object TrappingRainWater {
  def main(args: Array[String]) {
    var a = new TrappingRainWater
    println("waterTrapped:", a.trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)))

    println(Array(0,1,0,2,1,0,1,3,2,1,2,1).scan(0)(_ max _).drop(1).toList)
    println(Array(0,1,0,2,1,0,1,3,2,1,2,1).scan(0)(_ max _).toList)
    println(Array(0,1,0,2,1,0,1,3,2,1,2,1).scanRight(0)(_ max _).dropRight(1).toList)
    println(Array(0,1,0,2,1,0,1,3,2,1,2,1).scanRight(0)(_ max _).toList)
    println(Array(0,1,0,2,1,0,1,3,2,1,2,1).scan(0)(_ max _).drop(1)
      .zip(Array(0,1,0,2,1,0,1,3,2,1,2,1).scanRight(0)(_ max _).dropRight(1)).toList)
    println(Array(0,1,0,2,1,0,1,3,2,1,2,1).scan(0)(_ max _).drop(1)
      .zip(Array(0,1,0,2,1,0,1,3,2,1,2,1).scanRight(0)(_ max _).dropRight(1))
      .map(Function.tupled(_ min _)).toList)
  }
}
