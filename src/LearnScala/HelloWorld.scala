package LearnScala


/**
  * Created by lyk on 2019-8-24.
  * Package name: 
  * Porject name: LearnScala
  */
object HelloWorld {
  def main (args: Array[String] ) {
    def evenOrOdd(i: Int) = i match {
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
    }
    evenOrOdd(2)
    println(identity())
    println("hello world.")
    println(Array().length)
    val steps = Seq((-1, 0), (1, 0), (0, -1), (0, 1))
    for(i<- steps){
      println("(i, j)", i)
    }
    import scala.io.Source

    if (args.length > 0) {

      for (line <- Source.fromFile(args(0)).getLines())
        println(line.length + " " + line)
    }
    else
      Console.err.println("Please enter filename")
//
//    val lines = Source.fromFile(args(0)).getLines().toList
//    println(lines)
//    def widthOfLength(s: String) = s.length.toString.length
//    var maxWidth = 0
//    for (line <- lines) {
//      print("a:::", line)
//      print("{",line.length,"}")
//      print("{",line.length.toString,"}")
//      print("{",line.length.toString.length,"}")
//      maxWidth = maxWidth.max(widthOfLength(line))
//      println(":::b:::", maxWidth)
//    }
//    println("maxWidth [" + (maxWidth) + "]")


    import scala.io.Source

    def widthOfLength(s: String) = s.length.toString.length

    if (args.length > 0) {

      val lines = Source.fromFile(args(0)).getLines().toList

      val longestLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b
      )
      val maxWidth = widthOfLength(longestLine)

      for (line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }
    }
    else
      Console.err.println("Please enter filename")
  }
}
