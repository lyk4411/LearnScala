package Leetcode

/**
  * Created by lyk on 2019-9-27.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class BestTimetoBuyandSellStock {
  def maxProfit(prices: Array[Int]): Int = {
//    if(prices == null || prices.length ==0) 0
//    else prices.foldLeft(prices.head,0)((pair:(Int, Int), p)=> {
//      (Math.min(p, pair._1), Math.max(pair._2, p - pair._1) )
//    })._2
    println(prices.scan(Int.MaxValue)(math.min).tail.toList)
    println(prices.zip(prices.scan(Int.MaxValue)(math.min).tail).toList)
    println(prices.zip(prices.scan(Int.MaxValue)(math.min).tail).map(p=>p._1 - p._2).toList)
    prices.zip(prices.scan(Int.MaxValue)(math.min).tail).map(p => p._1 - p._2).foldLeft(0)(math.max)
  }
}
object BestTimetoBuyandSellStock {
  def main(args: Array[String]) {
    val a1 = Array(7,1,5,3,6,4)
    val a2 = Array(7,6,4,3,1)
    val t = new BestTimetoBuyandSellStock
    println(t.maxProfit(a1))
    println(t.maxProfit(a2))
  }
}
