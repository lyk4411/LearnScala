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

    println(
      persons filter (p => !p.isMale) flatMap (a =>
           (a.children map (c => (a.name, c.name))))
    )
    println(
      persons filter (p => !p.isMale)
    )
    println(
      persons filter (p => !p.isMale) map (c => c.children )
    )
    println(
      persons filter (p => !p.isMale) flatMap (c => c.children map (a => (c.name, a.name)))
    )
    println(
      persons withFilter (p => !p.isMale) flatMap (p =>
           (p.children map (c => (p.name, c.name))))
    )

    println(
      for (p <- persons; if !p.isMale; c <- p.children)
         yield (p.name, c.name)
    )
  }
}

