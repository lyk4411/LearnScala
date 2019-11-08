package Leetcode

/**
  * Created by lyk on 2019-11-8.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class MinStack {
  /** initialize your data structure here. */
  import java.util.TreeMap
  import collection.mutable.Stack
  val tm: TreeMap[Int, Int] = new TreeMap[Int, Int]()
  val stk: Stack[Int] = Stack()

  def push(x: Int): Unit = {
    stk.push(x)
    if(tm.containsKey(x)) {
      val freq = tm.get(x)
      tm.put(x, freq + 1)
    }
    else {
      tm.put(x, 1)
    }
  }
  def pop(): Unit = {
    val poped = stk.pop()
    val freq = tm.get(poped)
    if(freq == 1) {
      tm.remove(poped)
    }
    else {
      tm.put(poped, freq - 1)
    }
  }
  def top(): Int = {
    stk.top
  }
  def getMin(): Int = {
    tm.firstKey()
  }
}
object MinStack {
  def main(args: Array[String]) {
    val minStack = new MinStack
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    println(minStack.pop())
    println(minStack.top())
    println(minStack.getMin())
  }
}
