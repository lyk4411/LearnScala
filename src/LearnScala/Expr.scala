package LearnScala

/**
  * Created by lyk on 2019-8-30.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr

object Expr{
  def main(args: Array[String]) {
    val v = Var("x")
    val op = BinOp("+", Number(1), v)
    println("op:" + op)
    val opcopy = op.copy(operator = "-")
    println("opcopy:" + opcopy)
    simplifyTop(UnOp("-", UnOp("-", Var("x"))))
    val a = UnOp("-",UnOp("-",UnOp("-",UnOp("-",Var("2")))))
    println("a:" + a)
    println("simplifyTop a:" + simplifyTop(a))
    println("simplifyTop of simplifyTop a:" + simplifyTop(simplifyTop(a)))

  }
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))  => e   // Double negation
    case BinOp("+", e, Number(0)) => e   // Adding zero
    case BinOp("*", e, Number(1)) => e   // Multiplying by one
    case _ => expr
  }
}
