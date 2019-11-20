package LearnScala

/**
  * Created by lyk on 2019-11-20.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
case class SetRequest(key: String, value: Object)
import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging
import scala.collection.mutable.HashMap

class AkkademyDb  extends Actor {
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info("received SetRequest - key: {} value: {}", key , value)
      map.put(key, value)
    }
    case o => log.info("received unknown message: {}", o)
  }
}
object AkkademyDb {
  def main(args: Array[String]) {
    val system = ActorSystem("AkkademyDb")
    // default Actor constructor
    val AkkademyDb = system.actorOf(Props[AkkademyDb], name = "AkkademyDb")
    AkkademyDb ! SetRequest("hello", "world")
    AkkademyDb ! SetRequest("key", "value")
    while (true){
      val a = Console.readLine
      val b = Console.readLine
      AkkademyDb !  SetRequest(a,b)
    }
  }
}