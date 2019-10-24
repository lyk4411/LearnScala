package Leetcode

/**
  * Created by lyk on 2019-10-24.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
import scala.util.control.Exception._
class EvaluateReversePolishNotation {
  def evalRPN(tokens: Array[String]): Int = {
    val operators = List("+", "-", "*", "/")
    tokens.foldLeft(List[Int]()) ((stack, s) => s match {
      case num if isNumber(num) => s.toInt :: stack
      case op if operators contains op => stack match {
        case b :: a :: end => operate(a, b, s) :: end
      }
    }).head
  }
  def isNumber(s: String): Boolean = allCatch.opt(s.toInt).isDefined
  def operate(a: Int, b: Int, s: String): Int = s match {
    case "+" => return a+b
    case "-" => return a-b
    case "*" => return a*b
    case "/" => return a/b
  }
}
object EvaluateReversePolishNotation {
  def main(args: Array[String]) {
    val a = new EvaluateReversePolishNotation
    println(a.evalRPN(Array("2", "1", "+", "3", "*")))
    println(a.evalRPN(Array("4", "13", "5", "/", "+")))
    println(a.evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
  }
}
