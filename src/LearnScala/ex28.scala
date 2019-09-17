package LearnScala

/**
  * Created by lyk on 2019-9-17.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
abstract class CCTherm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int      // in US cents
  val purchasePrice: Int  // in US cents
  val condition: Int      // 1 to 10

  override def toString = description
  def toXML =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>
}

object ex28 {
//  def proc(node: scala.xml.Node): String =
//    node match {
//      case <a>{contents}</a> => "It's an a: " + contents
//      case <b>{contents}</b> => "It's a b: " + contents
//      case _ => "It's something else."
//    }
def proc(node: scala.xml.Node): String =
  node match {
    case <a>{contents @ _*}</a> => "It's an a: " + contents
    case <b>{contents @ _*}</b> => "It's a b: " + contents
    case _ => "It's something else."
  }
  def fromXML(node: scala.xml.Node): CCTherm =
    new CCTherm {
      val description   = (node \ "description").text
      val yearMade      = (node \ "yearMade").text.toInt
      val dateObtained  = (node \ "dateObtained").text
      val bookPrice     = (node \ "bookPrice").text.toInt
      val purchasePrice = (node \ "purchasePrice").text.toInt
      val condition     = (node \ "condition").text.toInt
    }
  def main(args: Array[String]) {
    val a = <a>
      This is some XML.
      Here is a tag:
      <atag/>
    </a>
    val b = <a>
      {"hello" + ", world"}
    </a>
    val yearMade = 1955
    val c = <a>
      {if (yearMade < 2000) <old>
        {yearMade}
      </old>
      else xml.NodeSeq.Empty}
    </a>
    println("a", a)
    println("b", b)
    println("c", c)

//    val therm = new CCTherm {
//      val description = "hot dog #5"
//      val yearMade = 1952
//      val dateObtained = "March 14, 2006"
//      val bookPrice = 2199
//      val purchasePrice = 500
//      val condition = 9
//    }
    val therm = new CCTherm {
         val description = "hot dog #5"
         val yearMade = 1952
         val dateObtained = "March 14, 2006"
         val bookPrice = 2199
         val purchasePrice = 500
         val condition = 9
       }
    println(1, therm.toXML)

    println(2, <a>Sounds <tag/> good</a>.text)

    println(30, <a><b><c>hello</c></b></a> \ "c")
    println(31, <a><b><c>hello</c></b></a> \\ "c")
    println(32, <a><b><c>hello</c></b></a> \ "a")
    println(33, <a><b><c>hello</c></b></a> \\ "a")
    println(34, <a><b><c>hello</c></b></a> \ "b")
    println(35, <a><b><c>hello</c></b></a> \\ "b")
    println(36, <a><e><c><d>hello</d></c></e></a> \ "e")
    println(37, <a><e><c><d>hello</d></c></e></a> \\ "e")
    println(38, <a><e><c><d>hello</d></c></e></a> \ "a")
    println(39, <a><e><c><d>hello</d></c></e></a> \\ "a")
    val joe = <employee
          name="Joe"
          rank="code monkey"
          serial="123"/>
    println(40, joe \ "@name")
    println(41, joe \ "@serial")

    val node = therm.toXML
    println(50, node)
    println(51, fromXML(node))

    scala.xml.XML.save("therm1.xml", node)
    val loadnode = xml.XML.loadFile("therm1.xml")
    println(60, loadnode)

    println(70, proc(<a>apple</a>))
    println(71, proc(<b>banana</b>))
    println(72, proc(<c>cherry</c>))
    println(73, proc(<a>a <em>red</em> apple</a>))
    println(74, proc(<a/>))
    println(75, proc(<a></a>))
    val a1: scala.xml.Node =  <a/>
    val a2: scala.xml.Node =  <a></a>
    println(76, a1)
    println(77, a2)

    val catalog =
      <catalog>
        <cctherm>
          <description>hot dog #5</description>
          <yearMade>1952</yearMade>
          <dateObtained>March 14, 2006</dateObtained>
          <bookPrice>2199</bookPrice>
          <purchasePrice>500</purchasePrice>
          <condition>9</condition>
        </cctherm>
        <cctherm>
          <description>Sprite Boy</description>
          <yearMade>1964</yearMade>
          <dateObtained>April 28, 2003</dateObtained>
          <bookPrice>1695</bookPrice>
          <purchasePrice>595</purchasePrice>
          <condition>5</condition>
        </cctherm>
      </catalog>
    println(80)
    catalog match {
      case <catalog>{therms @ _*}</catalog> =>
        for (therm <- therms)
          println("processing: " +
            (therm \ "description").text)
    }
    println(81)
    catalog match {
      case <catalog>{therms @ _*}</catalog> =>
        for (therm @ <cctherm>{_*}</cctherm>  <-  therms)
          println("processing: " +
            (therm \ "description").text)
    }
  }
}