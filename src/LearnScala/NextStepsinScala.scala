package LearnScala

/**
  * Created by lyk on 2019-8-24.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object  NextStepsinScala {
  def main(args: Array[String]) {
//    val oneTwoThree = List(1, 2, 3)
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo + " and " + threeFour + " were not mutated.")
    println("Thus, " + oneTwoThreeFour + " is a new list.")

    val twoThree = List(2, 3)
    val oneTwoThree = 1 :: twoThree
    println(oneTwoThree)

    val oneTwoThree1 = 1 :: 2 :: 3 :: Nil
    println(oneTwoThree1)

    val pair = (99, "Luftballons")
    println(pair._1)
    println(pair._2)

    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Cessna"))

    jetSet = jetSet + "Lear"
    import scala.collection.mutable

    val movieSet = mutable.Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)

    import scala.collection.immutable.HashSet

    val hashSet = HashSet("Tomatoes", "Chilies")
    println(hashSet + "Coriander")

    import scala.collection.mutable

    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))

    val romanNumeral = Map(
      1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
    )
    println(romanNumeral(4))

    def formatArgs(args: Array[String]) = args.mkString("\n")
    val res = formatArgs(Array("zero", "one", "two"))
    assert(res == "zero\none\ntwo")
    println(res)

  }
}
