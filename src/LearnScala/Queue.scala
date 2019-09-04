package LearnScala

/**
  * Created by lyk on 2019-9-3.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

//trait Queue[T] {
//  def head: T
//  def tail: Queue[T]
//  def enqueue(x: T): Queue[T]
//}

class Queue[+T] private (
                          private[this] var leading: List[T],
                          private[this] var trailing: List[T]
                        ) {

  private def mirror() =
    if (leading.isEmpty) {
      println("mirror:")
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: Queue[T] = {
    mirror()
    new Queue(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) =
    new Queue[U](leading, x :: trailing)
}
//
//object Queue {
//
//  def apply[T](xs: T*): Queue[T] =
//    new QueueImpl[T](xs.toList, Nil)
//
//  private class QueueImpl[T](
//                              private val leading: List[T],
//                              private val trailing: List[T]
//                            ) extends Queue[T] {
//
//    def mirror =
//      if (leading.isEmpty){
//        println("QueueImpl:")
//        new QueueImpl(trailing.reverse, Nil)
//      }
//      else
//        this
//
//    def head: T = mirror.leading.head
//
//    def tail: QueueImpl[T] = {
//      val q = mirror
//      new QueueImpl(q.leading.tail, q.trailing)
//    }
//
//    def enqueue(x: T) =
//      new QueueImpl(leading, x :: trailing)
//  }
//
//
//}

object Queue {
  def main(args: Array[String]) {
    var a = new Queue[Int](List(),List(4,5,6))
    println(a.head)
    println(a.head)
    println(a.head)
    println(a.head)
    println(a.head)
  }
//  var a = new Queue[Int]()
//  var b = a.enqueue(1)
//  var c = b.enqueue(2)
//  var d = c.enqueue(3)
//  println(d.head)
//  println(d.head)
//  println(d.head)
//  println(d.head)
//  println(d.tail.head)
//  println("=========================================")
//  val a1 = new Queue[Int](1, 2, 3, 4, 5, 6)
//  println(a1.head)
//  println(a1.tail.head)
//  println(a1.enqueue(7))
}
