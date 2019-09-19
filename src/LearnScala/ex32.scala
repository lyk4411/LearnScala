package LearnScala

import scala.concurrent.Promise

/**
  * Created by lyk on 2019-9-18.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
object ex32 {
  def main(args: Array[String]) {
    import scala.concurrent.Future
    import scala.concurrent.ExecutionContext.Implicits.global
//    val fut = Future { Thread.sleep(1000); 21 + 21 }
//    println(1,fut.value)
//    while(!fut.isCompleted){
//      Thread.sleep(100)
//    }
//    println(1, fut.value)
//
//    val fut1 = Future { Thread.sleep(1000); 21 / 0 }
//    println(2, fut1.value)
//    while(!fut1.isCompleted){
//      Thread.sleep(100)
//    }
//    println(2, fut1.value)
//
//    val fut2 = Future { Thread.sleep(1000); 42 + 42 }
//    val result = fut2.map(x => x + 1)
//    println(3,  result.value)
//    while(!fut2.isCompleted){
//      Thread.sleep(100)
//    }
//    println(3, fut2.value)
//
//    val fut11 = Future { Thread.sleep(1000); 21 + 21 }
//    val fut21 = Future { Thread.sleep(1000); 23 + 23 }
//    val result1 = for {
//      x <- fut11
//      y <- fut21
//    } yield x + y
//    println(4, result1.value)
//    println(4, result1.isCompleted)
//    while(!result1.isCompleted){
//      Thread.sleep(100)
//    }
//    println(4, result1.value)
    val p = Promise[Int]()
    val fut5 = p.future
    val r = 42
    p success r
//    val fut5 = Future { 42 }
//    while(!fut5.isCompleted){
//      Thread.sleep(100)
//    }
//    println(5, fut5.value)
//    println(5, fut5.value)
//    println(5, fut5.value)
//
//    val valid = fut5.filter(res => res > 0)
//    println(5, valid.value)
//    val invalid = fut5.filter(res => res < 0)
//    println(5, invalid.value)
//
//    val valid6 = for (res <- fut5 if res > 0) yield res
//    println(6, valid6.value)
//    val invalid6 = for (res <- fut5 if res < 0) yield res
//    println(6, invalid.value)
//    Thread.sleep(100)
    val valid7 =
      fut5 collect { case res if res > 0 => res + 46 }
    println(7, valid7.value)
    val invalid7 =
      fut5 collect { case res if res < 0 => res + 46 }
    println(7, invalid7.value)

  }
}
