/**
  * Created by lyk on 2019-9-9.
  * Package name: 
  * Porject name: LearnScala
  */
object ex23 {
  def main(args: Array[String]) {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)
    println("persons:", persons)
    println("female:",persons filter (p => !p.isMale))
    println("children:",persons filter (p => !p.isMale) flatMap (p =>
      (p.children)))
    println("children:",persons filter (p => !p.isMale) map (p =>
      (p.children)))
    println("children:",persons filter (p => !p.isMale) flatMap (p =>
      (p.children map (c => (p.name, c.name)))))
    persons filter (p => !p.isMale) flatMap (p =>
           (p.children map (c => (p.name, c.name))))
  }
}
case class Person(name: String,
                  isMale: Boolean,
                  children: Person*)
