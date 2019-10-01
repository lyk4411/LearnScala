package SCells

/**
  * Created by lyk on 2019-9-23.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

import scala.swing._
import scala.swing.event.TableUpdated
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
    reactions += {
      case TableUpdated(table, rows, column) =>
        for (row <- rows)
          cells(row)(column).formula =
            FormulaParsers.parse(userData(row, column))
      case ValueChanged(cell) =>
        updateCell(cell.row, cell.column)
      }
    for (row <- cells; cell <- row) listenTo(cell)
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

import swing._

class Model(val height: Int, val width: Int)
  extends Evaluator with Arithmetic{
//  case class Cell(row: Int, column: Int) {
//    var formula: Formula = Empty
//    def value = evaluate(formula)
//
//    override def toString = formula match {
//      case Textual(s) => s
//      case _ => value.toString
//    }
//  }
case class ValueChanged(cell: Cell) extends event.Event
case class Cell(row: Int, column: Int) extends Publisher {
  override def toString = formula match {
    case Textual(s) => s
    case _ => value.toString
  }
  private var v: Double = 0
  def value: Double = v
  def value_=(w: Double) = {
    if (!(v == w || v.isNaN && w.isNaN)) {
      v = w
      publish(ValueChanged(this))
    }
  }
  private var f: Formula = Empty
  def formula: Formula = f
  def formula_=(f: Formula) = {
    for (c <- references(formula)) deafTo(c)
    this.f = f
    for (c <- references(formula)) listenTo(c)
    value = evaluate(f)
  }
  reactions += {
    case ValueChanged(_) => value = evaluate(formula)
  }
}
  val cells = Array.ofDim[Cell](height, width)

  for (i <- 0 until height; j <- 0 until width)
    cells(i)(j) = new Cell(i, j)
}
