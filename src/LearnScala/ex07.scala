package LearnScala

/**
  * Created by lyk on 2019-8-29.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object  ex07 {
  def printMultiTable() = {
    var i = 1
    // only i in scope here
    while (i <= 10) {
      var j = 1
      // both i and j in scope here
      while (j <= 10) {
       val prod = (i * j).toString
        // i, j, and prod in scope here
        var k = prod.length
        // i, j, prod, and k in scope here
        while (k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      // i and j still in scope; prod and k out of scope
      println()
      i += 1
    }
    // i still in scope; j, prod, and k out of scope
  }

  def main(args: Array[String]) {
    val a = printMultiTable
    print(a)
  }
}
