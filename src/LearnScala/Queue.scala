package LearnScala

/**
  * Created by lyk on 2019-9-3.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}

object Queue {

  def apply[T](xs: T*): Queue[T] =
    new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](
                              private val leading: List[T],
                              private val trailing: List[T]
                            ) extends Queue[T] {

    def mirror =
      if (leading.isEmpty){
        println("QueueImpl:")
        new QueueImpl(trailing.reverse, Nil)
      }
      else
        this

    def head: T = mirror.leading.head

    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
  }


}

object queuetest extends App{
  var a = Queue[Int]()
  var b = a.enqueue(1)
  var c = b.enqueue(2)
  var d = c.enqueue(3)
  println(d.head)
  println(d.head)
  println(d.head)
  println(d.head)
  println(d.tail.head)
  println("=========================================")
  val a1 = Queue[Int](1, 2, 3, 4, 5, 6)
  println(a1.head)
  println(a1.tail.head)
  println(a1.enqueue(7))
}
