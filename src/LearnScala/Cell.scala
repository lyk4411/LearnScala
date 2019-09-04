package LearnScala

/**
  * Created by lyk on 2019-9-4.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class Cell[T](init: T) {
  private[this] var current = init
  def get = current
  def set(x: T) = { current = x }
}
object Cell{
  def main(args: Array[String]) {
    val c1 = new Cell[String]("abc")
    val c2: Cell[String] = c1
    c2.set("1")
    val s: String = c1.get

    val a1 = Array("abc")
    val a2: Array[Object] =
         a1.asInstanceOf[Array[Object]]
    a1.foreach(print)
    println
    a2.foreach(print)
  }
}