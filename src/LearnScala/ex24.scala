package LearnScala

import scala.collection.immutable.HashMap
import scala.collection.{LinearSeq, mutable, SortedSet}

/**
  * Created by lyk on 2019-9-16.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex24 {
  Traversable(1, 2, 3)
  Iterable("x", "y", "z")
  Map("x" -> 24, "y" -> 25, "z" -> 26)
  Set(Color.Red, Color.Green, Color.Blue)
  SortedSet("hello", "world")
//  mutable.Buffer(x, y, z)
  IndexedSeq(1.0, 2.0)
//  LinearSeq(a, b, c)
  List(1, 2, 3)
  HashMap("x" -> 24, "y" -> 25, "z" -> 26)

//  sealed abstract class Tree
  case class Branch(left: Tree, right: Tree) extends Tree
  case class Node(elem: Int) extends Tree
//  sealed abstract class Tree extends Traversable[Int] {
//    def foreach[U](f: Int => U) = this match {
//      case Node(elem) => f(elem)
//      case Branch(l, r) => l foreach f; r foreach f
//    }
//  }
  sealed abstract class Tree extends Iterable[Int] {
    def iterator: Iterator[Int] = this match {
      case Node(elem) => Iterator.single(elem)
      case Branch(l, r) => l.iterator ++ r.iterator
    }
  }
  import scala.reflect.ClassTag
  def evenElems[T: ClassTag](xs: Vector[T]): Array[T] = {
    val arr = new Array[T]((xs.length + 1) / 2)
    for (i <- 0 until xs.length by 2)
      arr(i / 2) = xs(i)
    arr
  }
  def f(x: String) = {
    println("taking my time."); Thread.sleep(10)
    x.reverse }
  def fibFrom(a: Int, b: Int): Stream[Int] =
       a #:: fibFrom(b, a + b)

  def lazyMap[T, U](coll: Iterable[T], f: T => U) =
    new Iterable[U] {
      def iterator = coll.iterator map f
    }

  def main(args: Array[String]) {
    println(1, List(1, 2, 3) map (_ + 1))
    println(2, Set(1, 2, 3) map (_ * 2))
    val xs = List(1, 2, 3, 4, 5)
    val git = xs grouped 3
    println(3, git)
    println(41, git.next)
    println(42, git.next)
    val sit = xs sliding 3
    println(51, sit.next)
    println(52, sit.next)
    println(53, sit.next)
    val fruit = Set("apple", "orange", "peach", "banana")
    println(61,fruit("peach"))
    println(62,fruit("potato"))
    var s = Set(1, 2, 3)
    s += 4; s -= 2
    println(71, s)
    val s1 = collection.mutable.Set(1, 2, 3)
    s1 += 4; s1 -= 2
    println(72, s1)
    val cache = collection.mutable.Map[String, String]()
//    def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))

    def cachedF(arg: String) = cache get arg match {
      case Some(result) => result
      case None =>
        val result = f(arg)
        cache(arg) = result
        result
    }
    println(81, cachedF("abc"))
    println(82, cachedF("abc"))

    val str = 1 #:: 2 #:: 3 #:: Stream.empty
    println(90, str)
    val fibs = fibFrom(1, 1).take(7)
    println(91, fibs.toList)

    val vec = scala.collection.immutable.Vector.empty
    val vec2 = vec :+ 1 :+ 2
    val vec3 = 100 +: vec2
    println(100,vec3(0))
    println(101,vec3)

    val set = collection.immutable.TreeSet.empty[Int]
    println(110, set + 1 + 3 + 3)

    val t1 = evenElems(Vector(1, 2, 3, 4, 5))
    println(120, t1.toList)
    println(121,evenElems(Vector("this", "is", "a", "test", "run")).toList)

    val v = Vector(1 to 10: _*)
    println(130, v)
    val v1 = 1 to 10
    println(131, v1)
    println(132, v map (_ + 1) map (_ * 2))
    println(133, v1 map (_ + 1) map (_ * 2))
    println(134, (v.view map (_ + 1) map (_ * 2)).force)
    val vv = v.view
    println(135, vv)
    println(136, vv.force)
    def isPalindrome(x: String) = x == x.reverse
    def findPalindrome(s: Seq[String]) = s find isPalindrome
    println(140,findPalindrome(Seq("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a")))
    println(141,findPalindrome(Seq("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a").view))
    def negate(xs: collection.mutable.Seq[Int]) =
         for (i <- 0 until xs.length) xs(i) = -xs(i)
    val arr = (0 to 9).toArray
    val subarr = arr.view.slice(3, 6)
    negate(subarr)
    println(150, arr.toList)
    val it = Iterator("a", "number", "of", "words")
    val (it1, it2) = it.duplicate
    println(160,it1.next(), 161, it2.next())
    import collection.JavaConversions._
    val jul: java.util.List[Int] = List(1, 2, 3)
    println(170, jul)
//    println(170, jul.add(7))
  }
}
