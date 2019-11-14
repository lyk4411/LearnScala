package LearnScala

/**
  * Created by lyk on 2019-11-14.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object LearnSliding {
  def main(args: Array[String]) {
    val xs = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    xs.sliding(4,1).foreach(println)
    xs.sliding(4,2).foreach(println)
    xs.sliding(4,3).foreach(println)
    xs.sliding(4,4).foreach(println)
  }
}
