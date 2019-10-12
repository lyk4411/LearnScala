package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ProductofArrayExceptSelf {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    var totalProduct = nums.product
    var zeroLength = nums.filter(x=>x==0).length
    zeroLength match{
      case 0 => nums.map(x=>totalProduct/x)
      case 1 => var value = nums.reduce((x,y)=>if(x==0) y else if(y==0) x else x*y); nums.map(x => if(x!=0) 0 else value)
      case _ => nums.map(x => 0)
    }
  }
}
object ProductofArrayExceptSelf {
  def main(args: Array[String]) {
    val a = new ProductofArrayExceptSelf
    println(a.productExceptSelf(Array(1, 2, 3, 4)).toList)
  }
}
