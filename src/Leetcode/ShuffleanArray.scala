package Leetcode

/**
  * Created by lyk on 2019-9-20.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ShuffleanArray(_nums: Array[Int])  {
  def reset(): Array[Int] = {
    return _nums
  }

  /** Returns a random shuffling of the array. */
  def shuffle(): Array[Int] = {
    return scala.util.Random.shuffle(_nums.toList).toArray
  }
}
