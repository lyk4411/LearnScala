package LearnScala

/**
  * Created by lyk on 2019-11-1.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class LetterCombinationsofaPhoneNumber {
  def letterCombinations(digits: String): List[String] = {
    if(digits.length == 0){
      return List()
    }
    val digits_map: Map[String, List[String]]= Map(
      "2" -> List("a", "b", "c"),
      "3" -> List("d", "e", "f"),
      "4" -> List("g", "h", "i"),
      "5" -> List("j", "k", "l"),
      "6" -> List("m", "n", "o"),
      "7" -> List("p", "q", "r", "s"),
      "8" -> List("t", "u", "v"),
      "9" -> List("w", "x", "y", "z"))
    letterCombinations(digits_map, digits, "")
  }
  def letterCombinations(digits_map: Map[String, List[String]], digits: String, curr_string: String) : List[String] = {
    if(digits.length == 0){
      return List(curr_string)
    } else {
      var all_combinations: List[String] = List()

      for(digit <- digits_map(digits.charAt(0).toString)){
        val single_combination = letterCombinations(digits_map, digits.substring(1), curr_string.concat(digit.toString))
        all_combinations = List.concat(all_combinations, single_combination)
      }
      all_combinations
    }
  }
}
object LetterCombinationsofaPhoneNumber {
  def main(args: Array[String]) {
    val a = new LetterCombinationsofaPhoneNumber
    println(a.letterCombinations("23"))
    println(a.letterCombinations("234"))
  }
}
