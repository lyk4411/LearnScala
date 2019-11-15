package Leetcode

/**
  * Created by lyk on 2019-11-15.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ConstructtheRectangle {
  def constructRectangle(area: Int): Array[Int] = {
    var w = Math.sqrt(area).toInt
    while(area % w != 0) w = w - 1;
    Array(area / w, w)
  }
}
object ConstructtheRectangle {
  def main(args: Array[String]) {
    val a = new ConstructtheRectangle
    a.constructRectangle(4).toList.foreach(println)
    a.constructRectangle(17).toList.foreach(println)
  }
}
