package LearnScala

/**
  * Created by lyk on 2019-8-24.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object BuiltinControlStructures {
  def main(args: Array[String]) {
    val filesHere = (new java.io.File("./src/LearnScala")).listFiles

//    for (
//      file <- filesHere
//      if file.isFile
//      if file.getName.endsWith(".scala")
//    ) println(file)


    def fileLines(file: java.io.File) =
      scala.io.Source.fromFile(file).getLines().toList

//    def grep(pattern: String) =
//      for {
//        file <- filesHere if file.getName.endsWith(".scala")
//        line <- fileLines(file) if line.trim.matches(pattern)
//      } println(file + ": " + line.trim)
    def grep(pattern: String) =
      for {
        file <- filesHere if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim if trimmed.matches(pattern)
      } println(file + ": " + trimmed)

    grep(".*gcd.*")

    def scalaFiles =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
      } yield file
    for(i <- 0 until scalaFiles.length)
      println(i + ":" + scalaFiles(i))

    val forLineLengths =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(".*for.*")
      } yield trimmed.length

    for(i <- 0 until forLineLengths.length)
      println(i + ":" + forLineLengths(i))


    def f(): Int = try return 1 finally return 2
    def g(): Int = try 1 finally 2
    println("f():" + f())
    println("g():" + g())

  }
}
