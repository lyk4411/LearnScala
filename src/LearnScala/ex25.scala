package LearnScala


/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex25 {
  def main(args: Array[String]) {
    val xs = List(A, G, T, A)
    val rna2 = RNA1.fromSeq(xs)
    println(rna2.length)

    val rna1 = RNA1(A, U, G, G, T)
    println(rna1.length)
    println(rna1.last)
    println(rna1.take(3))
    println("==============================================")
    val rna21 = RNA2(A, U, G, G, T)
    println(rna21 take 3)
    println(rna21 filter (U !=))
  }
}

abstract class Base
case object A extends Base
case object T extends Base
case object G extends Base
case object U extends Base

object Base {
  val fromInt: Int => Base = Array(A, T, G, U)
  val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
}

import collection.IndexedSeqLike
import collection.mutable.{Builder, ArrayBuffer}
import scala.collection.generic.CanBuildFrom

final class RNA1 private (val groups: Array[Int],
                          val length: Int) extends IndexedSeq[Base] {

  import RNA1._

  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }
}

object RNA1 {

  // Number of bits necessary to represent group
  private val S = 2

  // Number of groups that fit in an Int
  private val N = 32 / S

  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA1(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}


final class RNA2 private (
                           val groups: Array[Int],
                           val length: Int
                         ) extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA2] {

  import RNA2._

  override def newBuilder: Builder[Base, RNA2] =
    new ArrayBuffer[Base] mapResult fromSeq

  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }
}

object RNA2 {

  // Number of bits necessary to represent group
  private val S = 2

  // Number of groups that fit in an Int
  private val N = 32 / S

  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: Seq[Base]): RNA2 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA2(groups, buf.length)
  }
  def apply(bases: Base*) = fromSeq(bases)
}


final class RNA private (val groups: Array[Int], val length: Int)
  extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA] {

  import RNA._

  // Mandatory re-implementation of `newBuilder` in `IndexedSeq`
  override protected[this] def newBuilder: Builder[Base, RNA] =
    RNA.newBuilder

  // Mandatory implementation of `apply` in `IndexedSeq`
  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  // Optional re-implementation of foreach,
  // to make it more efficient.
  override def foreach[U](f: Base => U): Unit = {
    var i = 0
    var b = 0
    while (i < length) {
      b = if (i % N == 0) groups(i / N) else b >>> S
      f(Base.fromInt(b & M))
      i += 1
    }
  }
}


object RNA {

  private val S = 2            // number of bits in group
  private val M = (1 << S) - 1 // bitmask to isolate a group
  private val N = 32 / S       // number of groups in an Int

  def fromSeq(buf: Seq[Base]): RNA = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)

  def newBuilder: Builder[Base, RNA] =
    new ArrayBuffer mapResult fromSeq

  implicit def canBuildFrom: CanBuildFrom[RNA, Base, RNA] =
    new CanBuildFrom[RNA, Base, RNA] {
      def apply(): Builder[Base, RNA] = newBuilder
      def apply(from: RNA): Builder[Base, RNA] = newBuilder
    }
}