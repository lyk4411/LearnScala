package LearnScala
import scala.collection.Seq
/**
  * Created by lyk on 2019-9-17.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex26 {
  def userTwiceUpper(s: String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) =>
      "match: " + x + " in domain " + domain
    case _ =>
      "no match"
  }
  def isTomInDotCom(s: String): Boolean = s match {
    case EMail("tom", Domain("com", _*)) => true
    case _ => false
  }

  def main(args: Array[String]) {
    val a = EMail("user", "domain")
    println(1, a)
    println(20, userTwiceUpper("DIDI@hotmail.com"))
    println(21, userTwiceUpper("DIDO@hotmail.com"))
    println(22, userTwiceUpper("didi@hotmail.com"))
    println(30, isTomInDotCom("tom@sun.com"))
    println(31, isTomInDotCom("peter@sun.com"))
    println(32, isTomInDotCom("tom@com.org"))
    val s = "tom@support.epfl.ch"
    val ExpandedEMail(name, topdom, subdoms @ _*) = s
    println(40, name)
    println(41, topdom)
    println(42, subdoms)

    import scala.util.matching.Regex

//    val Decimal = new Regex("(-)?(\\d+)(\\.\\d*)?")
//    val Decimal = new Regex("""(-)?(\d+)(\.\d*)?""")
    val Decimal = """(-)?(\d+)(\.\d*)?""".r
    val input = "for -1.0 to 99 by 3"
    for (s <- Decimal findAllIn input)
       println(50, s)
    println(51, Decimal findFirstIn input)
    println(52, Decimal findPrefixOf input)
    val Decimal(sign, integerpart, decimalpart) = "-1.23"
    println(60, sign)
    println(61, integerpart)
    println(62, decimalpart)

    for (Decimal(s, i, d) <- Decimal findAllIn input)
          println(63, "sign: " + s + ", integer: " +  i + ", decimal: " + d)


  }
}

object EMail {

  // The injection method (optional)
  def apply(user: String, domain: String) = user + "@" + domain

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}
object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }
}
object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}

object Domain {

  // The injection method (optional)
  def apply(parts: String*): String =
    parts.reverse.mkString(".")

  // The extraction method (mandatory)
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}
object ExpandedEMail {
  def unapplySeq(email: String) : Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }
}




