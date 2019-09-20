package LearnScala

/**
  * Created by lyk on 2019-9-20.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
import scala.swing._
import scala.swing.event._

object ReactiveSwingApp extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Reactive Swing App"
    val button = new Button {
      text = "Click me"
    }
    val button1 = new Button {
      text = "Click me too"
    }
    val label = new Label {
      text = "No button clicks registered"
    }
    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      contents += button1
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
    listenTo(button)
    var nClicks = 0
    reactions += {
      case ButtonClicked(`button`) =>
        nClicks += 1
        label.text = "Number of button clicks: " + nClicks
      case ButtonClicked(`button1`) =>
        nClicks += 10
        label.text = "Number of button clicks: " + nClicks
    }
    listenTo(button1)

  }
}
