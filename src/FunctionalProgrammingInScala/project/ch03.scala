package FunctionalProgrammingInScala.project

/**
  * Created by lyk on 2019-10-1.
  * Package name: FunctionalProgrammingInScala.project
  * Porject name: LearnScala
  */
object ch03 {
  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] =
    as match {
      case Cons(h, t) if f(h) => dropWhile(t)(f)
      case _ => as
    }

  def main(args: Array[String]) {
    val a = ch03
    val b = List(1,2,3,4,5,6,7,8)
    println(b)
    println(a.dropWhile(b)(_<4))
  }
}
