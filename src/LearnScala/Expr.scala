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
    simplifyAll(UnOp("-", UnOp("-", Var("x"))))
    val a = UnOp("-",UnOp("-",UnOp("-",UnOp("-",Var("2")))))
    println("a:" + a)
    println("simplifyTop a:" + simplifyAll(a))
    println("simplifyTop of simplifyTop a:" + simplifyAll(simplifyAll(a)))

  }
  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) =>
      simplifyAll(e)   // `-' is its own inverse
    case BinOp("+", e, Number(0)) =>
      simplifyAll(e)   // `0' is a neutral element for `+'
    case BinOp("*", e, Number(1)) =>
      simplifyAll(e)   // `1' is a neutral element for `*'
    case UnOp(op, e) =>
      UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) =>
      BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }
}
