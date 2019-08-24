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
  }
}
