package LearnScala

import scala.concurrent.Promise
import scala.util.{Failure, Success}

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
//    val valid7 =
//      fut5 collect { case res if res > 0 => res + 46 }
//    println(7, valid7.value)
//    val invalid7 =
//      fut5 collect { case res if res < 0 => res + 46 }
//    println(7, invalid7.value)
//
//
//
    val failure = Future { 42 / 0 }
    failure onComplete {
      case Success(a) => println(80, failure.value)
      case Failure(a) => println(80, "futureList failure.")
    }
//    println(80,  failure.value)
    val expectedFailure = failure.failed
    expectedFailure onComplete {
      case Success(res) => println(81, expectedFailure.value)
      case Failure(res) => println(81, "expectedFailure failure.")
    }
//    println(81, expectedFailure.value)

    val fortyTwo = Future { 21 + 21 }
    val fortySix = Future { 23 + 23 }
    val futureNums = List(fortyTwo, fortySix)
    val folded =
      Future.fold(futureNums)(0) { (acc, num) =>
        acc + num
      }
    while(!folded.isCompleted){
      Thread.sleep(100)
    }
    println(9, folded.value)

    val reduced =
      Future.reduce(futureNums) { (acc, num) =>
        acc + num
      }
    while(!reduced.isCompleted){
      Thread.sleep(100)
    }
    if(reduced.isCompleted){
      println(10, reduced.value)
    }
    val futureList = Future.sequence(futureNums)
//    while(!futureList.isCompleted){
//      Thread.sleep(100)
//    }
    futureList onComplete {
      case Success(res) => println(120, futureList.value)
      case Failure(res) => println(121, "futureList failure.")
    }
    println(11, futureNums)
    println(12, futureList.value)

    val futNum = Future {  21 + 21 }
    val futStr = Future { "ans" + "wer" }
    val zipped = futNum zip futStr
    val mapped = zipped map {
      case (num, str) => s"$num is the $str"
    }
//    while(!mapped.isCompleted){
//      Thread.sleep(100)
//    }
    mapped onComplete {
      case Success(res) => println(130, mapped.value)
      case Failure(res) => println(131, "mapped failure.")
    }
//    println(13, mapped.value)

    import scala.concurrent.Await
    import scala.concurrent.duration._
    val fut = Future { Thread.sleep(1000); 21 + 21 }
    val x = Await.result(fut, 2.seconds)
    println(14, x)


  }
}
