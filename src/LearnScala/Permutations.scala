package LearnScala

/**
  * Created by lyk on 2019-11-1.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class Permutations {
  def permute(nums: Array[Int]): List[List[Int]] = {
    def permute(rem: Set[Int]): Set[List[Int]] =
      if (rem.isEmpty) Set(Nil)
      else rem flatMap (n => permute(rem - n) map (n :: _))
    permute(nums.toSet).toList
  }

  def permute(rem: Set[Int]): Set[List[Int]] =
    if (rem.isEmpty) Set(Nil)
    else rem flatMap (n => permute(rem - n) map (n :: _))

//  def permute(nums: Array[Int]): List[List[Int]] = {
//    if (nums.isEmpty) {
//      List(List())
//    } else {
//      for {
//        x <- nums.toList
//        perm <- permute(nums.filter(_ != x))
//      } yield x :: perm
//    }
//  }
}
object Permutations {
  def main(args: Array[String]) {
    val a = new Permutations
    println(a.permute(Array(1, 2, 3)))
    println(a.permute(Set(1, 2, 3)))

  }
}
