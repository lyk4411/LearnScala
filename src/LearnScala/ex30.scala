package LearnScala

/**
  * Created by lyk on 2019-9-17.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex30 {
  object Color extends Enumeration {
    val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
  }
  class Point(val x: Int, val y: Int) {
    override def hashCode = (x, y).##
    override def equals(other: Any) = other match {
      case that: Point =>
        (that canEqual this) &&
          (this.x == that.x) && (this.y == that.y)
      case _ =>
        false
    }
    def canEqual(other: Any) = other.isInstanceOf[Point]
  }
  class ColoredPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) {

    override def hashCode = (super.hashCode, color).##
    override def equals(other: Any) = other match {
      case that: ColoredPoint =>
        (that canEqual this) &&
          super.equals(that) && this.color == that.color
      case _ =>
        false
    }
    override def canEqual(other: Any) =
      other.isInstanceOf[ColoredPoint]
  }

  trait Tree[+T] {
    def elem: T
    def left: Tree[T]
    def right: Tree[T]
  }

  object EmptyTree extends Tree[Nothing] {
    def elem =
      throw new NoSuchElementException("EmptyTree.elem")
    def left =
      throw new NoSuchElementException("EmptyTree.left")
    def right =
      throw new NoSuchElementException("EmptyTree.right")
  }

  class Branch[T](
                   val elem: T,
                   val left: Tree[T],
                   val right: Tree[T]
                 ) extends Tree[T] {
    override def equals(other: Any) = other match {
      case that: Branch[_] => (that canEqual this) &&
        this.elem == that.elem &&
        this.left == that.left &&
        this.right == that.right
      case _ => false
    }

    def canEqual(other: Any) = other.isInstanceOf[Branch[_]]

    override def hashCode: Int = (elem, left, right).##
  }


  class Rational(n: Int, d: Int) {

    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val numer = (if (d < 0) -n else n) / g
    val denom = d.abs / g

    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    override def equals(other: Any): Boolean =
      other match {
        case that: Rational =>
          (that canEqual this) &&
            numer == that.numer &&
            denom == that.denom
        case _ => false
      }

    def canEqual(other: Any): Boolean =
      other.isInstanceOf[Rational]

    override def hashCode: Int = (numer, denom).##

    override def toString =
      if (denom == 1) numer.toString else numer + "/" + denom
  }


  def main(args: Array[String]) {
    val p = new Point(1, 2)
    val cp = new ColoredPoint(1, 2, Color.Indigo)
    val pAnon = new Point(1, 1) { override val y = 2 }
    val coll = List(p)
    println(1, coll contains p)
    println(2, coll contains cp)
    println(3, coll contains pAnon)
    val b1 = new Branch[List[String]](Nil,
            EmptyTree, EmptyTree)
    val b2 = new Branch[List[Int]](Nil,
            EmptyTree, EmptyTree)
    println(4, b1 == b2)

    val r1 = new Rational(4, 2)
    val r2 = new Rational(2, 1)
    println(5, r1 == r2)
  }
}
