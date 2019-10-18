package Leetcode

/**
  * Created by lyk on 2019-10-18.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class CompareVersionNumbers {
  def compareVersion(version1: String, version2: String): Int = {
    def _cv(v1:List[String],v2:List[String]):Int = (v1,v2) match {
      case (Nil,Nil) => 0
      case (v,Nil) => if(v.head.toInt == 0) _cv(v.tail,Nil) else 1
      case (Nil,v) => if(v.head.toInt == 0) _cv(Nil,v.tail) else -1
      case (x,y) => {
        if(x.head.toInt > y.head.toInt) 1
        else if(x.head.toInt < y.head.toInt) -1
        else _cv(x.tail,y.tail)
      }
    }
    _cv(
      version1.split("\\.").map(_.toString).toList,                 //just a ceremony to convert a version string into a list of String.
      version2.split("\\.").map(_.toString).toList)
  }
}
object CompareVersionNumbers {
  def main(args: Array[String]) {
    val a = new CompareVersionNumbers
    println(a.compareVersion(version1 = "0.1", version2 = "1.1"))
    println(a.compareVersion(version1 = "1.0.1", version2 = "1.1"))
    println(a.compareVersion(version1 = "7.5.2.4", version2 = "7.5.3"))
    println(a.compareVersion(version1 = "1.01", version2 = "1.001"))
    println(a.compareVersion( version1 = "1.0", version2 = "1.0.0"))
  }
}
