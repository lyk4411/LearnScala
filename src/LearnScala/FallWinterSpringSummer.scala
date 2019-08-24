package LearnScala

/**
  * Created by lyk on 2019-8-24.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {

  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
  for (season <- List("of", "love"))
    println(season + ": " + calculate(season))
}
