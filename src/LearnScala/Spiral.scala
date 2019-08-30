package LearnScala

/**
  * Created by lyk on 2019-8-30.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
import Element.elem

object Spiral {

  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

  def main(args: Array[String]) = {

    for (i <- 0 until args.length) {
      println("number i is: " + args(i))
      val nSides = args(i).toInt
      println(spiral(nSides, 0))
      println("=====================================================")
    }
  }
}