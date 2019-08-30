package LearnScala

/**
  * Created by lyk on 2019-8-30.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex08 {
  def main(args: Array[String]) {
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    def echo(args: String*) =
         for (arg <- args) println(arg)
    echo("hello","world.")
    val arr0 = Array("What's", "up", "doc?")
    val arr1 = Array("hello","world.")
    println("=================")
    echo(arr0: _*)

  }
}
