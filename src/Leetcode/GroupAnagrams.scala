package Leetcode

/**
  * Created by lyk on 2019-10-31.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class GroupAnagrams {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.groupBy(_.sorted).values.map(_.toList).toList
  }
}
object GroupAnagrams {
  def main(args: Array[String]) {
    val a = new GroupAnagrams
    println(a.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
  }
}
