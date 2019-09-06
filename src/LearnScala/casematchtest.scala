package LearnScala

/**
  * Created by lyk on 2019-9-6.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object casematchtest {
  def main(args: Array[String]) {
    val Pattern="(s.*)".r

    val v1="spark";

    val r=v1 match  {
      case Pattern(v1)=> "begin s*"
      case "1"=> "1"
      case "2"=> "2"
      case _=> "default"
    }

    println(r) // begin s*

    val v2=3

    val r1=v2 match  {
      case v2 if 1 until 5 contains v2=> "1-5"
      case v2 if 5 until 10 contains v2=> "5-10"
      case _=> "not found"
    }
    println(r1)

    def glob(x:Any):Any= x match {
      case   1 | "1" | "one"  => "one "
      case "two"=> 2
      case s:String => "String"
      case y:Int=>"Int 类型 "
      case _ => "其他"
    }

    println(glob(4))//Int 类型

    def describe(x: Any): Any = x match {
         case 5 => "five"
         case true => "truth!"
         case "spark" => "the future!"
         case Nil => "the empty list"
         case _ => "something else"
         }
    println(describe(5))
    println(describe(true))
    println(describe(Array(1,2,3,4,5,6)))

    println(
      List(0, 1, 2) match {
     case List(0, _, _) => "success"
       }
    )
    println(
      (1, "scala", true) match {
       case (a, b, c) => "matched " + a + b + c
         }
    )
    def generalSize(x: Any) = x match{
      case s: String => s.length
      case m: Map[_, _] => m.size
      case _ => -1
    }
    println(generalSize("abc"))

    println(
      "apple" match{
     case s: String if s(0) == 'a' => "the " + s + " is start with a "
       case _ => "something else"
      }
    )
  }
}
