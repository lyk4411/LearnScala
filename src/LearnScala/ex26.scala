package LearnScala

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

  def main(args: Array[String]) {
    val a = EMail("user", "domain")
    println(1, a)
    println(20, userTwiceUpper("DIDI@hotmail.com"))
    println(21, userTwiceUpper("DIDO@hotmail.com"))
    println(22, userTwiceUpper("didi@hotmail.com"))

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
