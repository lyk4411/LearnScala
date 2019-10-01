package LearnScala

/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

package org.stairwaybook.scells
import swing._

class Spreadsheet(val height: Int, val width: Int)
  extends ScrollPane {
  val table = new Table(height, width) {
    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new java.awt.Color(150, 150, 150)

    val cellModel = new Model(height, width)
    import cellModel._
    override def rendererComponent(isSelected: Boolean,
                                   hasFocus: Boolean, row: Int, column: Int): Component =

        if (hasFocus) new TextField(userData(row, column))
        else
          new Label(cells(row)(column).toString) {
            xAlignment = Alignment.Right
          }

      def userData(row: Int, column: Int): String = {
        val v = this(row, column)
        if (v == null) "" else v.toString
      }
    }


  val rowHeader =
    new ListView((0 until height) map (_.toString)) {
      fixedCellWidth = 30
      fixedCellHeight = table.rowHeight
    }

  viewportView = table
  rowHeaderView = rowHeader
}
object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet(100, 26)
  }
}


class Model(val height: Int, val width: Int) {
  case class Cell(row: Int, column: Int)
  val cells = Array.ofDim[Cell](height, width)
  for (i <- 0 until height; j <- 0 until width)
    cells(i)(j) = new Cell(i, j)
}
