package LearnScala

/**
  * Created by lyk on 2019-11-11.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object LearnCom {
  def main(args: Array[String]) {
    val list = List(1, 2, 3)
    val combs = list.combinations(2)
    combs.foreach(println)
    println("==================")
    val combs1 = list.reverse.combinations(2)
    combs1.foreach(println)
    println("==================")
    println(List(3, 2) == List(2, 3))
  }
}
