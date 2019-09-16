package LearnScala


/**
  * Created by lyk on 2019-9-12.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex23 {
  case class Person(name: String,
                    isMale: Boolean,
                    children: Person*)

  def main(args: Array[String]) {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    println(1,
      persons filter (p => !p.isMale) flatMap (a =>
           (a.children map (c => (a.name, c.name))))
    )
    println(2,
      persons filter (p => !p.isMale)
    )
    println(3,
      persons filter (p => !p.isMale) map (c => c.children )
    )
    println(31,
      persons filter (p => !p.isMale) map (c => c.children ) flatMap(a => a) map( b => (b.name))
    )
    println(4,
      persons filter (p => !p.isMale) flatMap (c => c.children )
    )
    println(5,
      persons filter (p => !p.isMale) flatMap (c => c.children map (a => (c.name, a.name)))
    )
    println(6,
      persons withFilter (p => !p.isMale) flatMap (p =>
           (p.children map (c => (p.name, c.name))))
    )

    println(7,
      for (p <- persons; if !p.isMale; c <- p.children)
         yield (p.name, c.name)
    )
    val a =
    for (p <- persons; n = p.name; if (n startsWith "B"))
      yield n
    println(8, a)
    val b = for {
      p <- persons              // a generator
      n = p.name                // a definition
      if (n startsWith "B")    // a filter
    } yield n
    println(9, b)

    val c = for (x <- List(1, 2); y <- List("one", "two"))
       yield (x, y)
    println(10, c)

    def queens(n: Int): List[List[(Int, Int)]] = {
      def placeQueens(k: Int): List[List[(Int, Int)]] =
        if (k == 0)
          List(List())
        else
          for {
            queens <- placeQueens(k - 1)
            column <- 1 to n
            queen = (k, column)
            if isSafe(queen, queens)
          } yield queen :: queens

      placeQueens(n)
    }
    def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
      queens forall (q => !inCheck(queen, q))

    def inCheck(q1: (Int, Int), q2: (Int, Int)) =
      q1._1 == q2._1 ||  // same row
        q1._2 == q2._2 ||  // same column
        (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on diagonal

//    println(11, queens(8))
    println
    val ds = queens(8)
    var i = 1
    for (d <- ds) {
      println(i, d)
      i += 1
    }


    case class Book(title: String, authors: String*)
    val books: List[Book] =
      List(
        Book(
          "Structure and Interpretation of Computer Programs",
          "Abelson, Harold", "Sussman, Gerald J."
        ),
        Book(
          "Principles of Compiler Design",
          "Aho, Alfred", "Ullman, Jeffrey"
        ),
        Book(
          "Programming in Modula-2",
          "Wirth, Niklaus"
        ),
        Book(
          "Elements of ML Programming",
          "Ullman, Jeffrey"
        ),
        Book(
          "The Java Language Specification", "Gosling, James",
          "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
        )
      )
    val bs = for (b <- books; a <- b.authors if a startsWith "Gosling")
      yield b.title
    println(11, bs)
    val bs1 = for (b <- books if (b.title indexOf "Program") >= 0)
      yield b.title
    println(12, bs1)

    for (b <- books if (b.title indexOf "Program") >= 0)
      println(13, b.title)
  }
}

