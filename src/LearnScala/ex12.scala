package LearnScala
import scala.collection.mutable.ArrayBuffer
/**
  * Created by lyk on 2019-8-30.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex12 {
  def main(args: Array[String]) {
    val q = new BasicIntQueue with Incrementing with Doubling
    q.put(42)
    print(q.get())
  }
}
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }
}
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}