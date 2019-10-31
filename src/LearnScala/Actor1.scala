package LearnScala

/**
  * Created by lyk on 2019-10-31.
  * Package name: LearnScala
  * Porject name: LearnScala
  */
import scala.actors.Actor

case class Message(actor:Actor, msg:Any)

class Actor1 extends Actor {
  def act() {
    while(true) {
      receive{
        case msg :Message => {
          println("i sava msg ! = "+ msg.msg)
          msg.actor ! "i love you too !"
        }
        case msg :String => println(msg)
        case  _ => println("default msg!")
      }
    }
  }
}