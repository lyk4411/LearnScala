package LearnScala

/**
  * Created by lyk on 2019-9-2.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex16 {
  def msort[T](less: (T, T) => Boolean)
              (xs: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
  def flattenLeft[T](xss: List[List[T]]) =
    (List[T]() /: xss) (_ ::: _)
  def reverseLeft[T](xs: List[T]) =
    (List[T]() /: xs) {(ys, y) => y :: ys}

  def main(args: Array[String]) {
    val res = msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
    println(res)
    val intSort = msort((x: Int, y: Int) => x < y) _
    val reverseIntSort = msort((x: Int, y: Int) => x > y) _
    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
    val res1 = intSort(mixedInts)
    println(res1)
    val res2 = reverseIntSort(mixedInts)
    println(res2)


    val words = List("the", "the", "the", "quick", "brown", "fox", "the")
    println(words map (_.toList))
    println(words flatMap (_.toList))
    println(
    List.range(1, 5) flatMap (
         i => List.range(1, i) map(j => (i, j))
      )
    )
    println(for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j))

    println(words dropWhile (_ startsWith "t"))


    println((" " /: words) (_ + " " + _))
    println(("" /: words) (_ + " " + _))
    println((words.head /: words.tail)  (_ + " " + _))

    println(flattenLeft(List(List("abc"),List("123"),List("456"),List("789"))))
    println("a"::List("bc"))
    println(List("a")::List("bc"))
    println(List("a"):::List("bc"))
    println(reverseLeft(words))

  }

}
