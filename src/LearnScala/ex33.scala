package LearnScala

/**
  * Created by lyk on 2019-9-29.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
class ex33 {

}
import scala.util.parsing.combinator._

class Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term~rep("+"~term | "-"~term)
  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
  def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
}