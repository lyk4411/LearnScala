package LearnScala


import javax.swing.JButton

import org.junit.Test
import org.junit.Assert.assertEquals

/**
  * Created by lyk on 2019-9-18.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex31 {
  class SetTest {
    @Test
    def testMultiAdd = {
      val set = Set() + 1 + 2 + 3 + 1 + 2 + 3
      assertEquals(3, set.size)
    }
  }
  import scala.collection.mutable
  import java.util.Collection

  abstract class SetAndType {
    type Elem
    val set: mutable.Set[Elem]
  }

  def javaSet2ScalaSet[T](jset: Collection[T]): SetAndType = {
    val sset = mutable.Set.empty[T]  // now T can be named!

    val iter = jset.iterator
    while (iter.hasNext)
      sset += iter.next()

    return new SetAndType {
      type Elem = T
      val set = sset
    }
  }

  def main(args: Array[String]) {
    val a = new SetTest()
    a.testMultiAdd

    val contents = (new Wild).contents
    println(1, contents)

    import scala.collection.mutable
    val iter = (new Wild).contents.iterator
    val set = mutable.Set.empty[SetAndType]     // what type goes here?
    while (iter.hasNext)
      println(2, iter.next())

    val c = increaseOne(
      new Increaser {
        def increase(i: Int): Int = i + 7
      }
    )
    println(3, c)
    import java.util.Arrays
    import java.util.function.IntUnaryOperator
    val stream = Arrays.stream(Array(1, 2, 3))
    stream.map(
      new IntUnaryOperator {
        def applyAsInt(i: Int): Int = i + 1
      }
    ).toArray

    val stream1 = Arrays.stream(Array(1, 2, 3))
    println(4, stream1.toArray.toList)

  }
  trait Increaser {
    def increase(i: Int): Int
  }
  def increaseOne(increaser: Increaser): Int =
    increaser.increase(1)
}
