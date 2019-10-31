package LearnScala

/**
  * Created by lyk on 2019-10-31.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
import scala.actors.Actor

class Actor2(actor :Actor) extends Actor {
  actor ! Message(this,"i love you !")
  def act() {
    while(true) {
      receive {
        case msg :String => {
          if(msg.equals("i love you too !")) {
            println("Actor2: " + msg)
            actor! "could we have a date !"
          }
        }
        case  _ => println("default msg!")
      }
    }
  }
}

object Lesson_Actor2 {
  def main(args: Array[String]): Unit = {
    val actor1 = new Actor1()
    actor1.start()
    val actor2 = new Actor2(actor1)
    actor2.start()
  }
}