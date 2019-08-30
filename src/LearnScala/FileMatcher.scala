package LearnScala

/**
  * Created by lyk on 2019-8-30.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object FileMatcher {
  private def filesHere = (new java.io.File("./src/LearnScala")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  def main(args: Array[String]) {
    filesHere.foreach(println)
    println("===================")
    filesEnding("scala").foreach(println)
    println("===================")
    filesContaining("matchcase").foreach(println)

  }
}
