package LearnScala

/**
  * Created by lyk on 2019-11-19.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

import akka.actor.{ActorSystem, Props}
import akka.actor.{Actor, ActorRef}

/**
  * 定义玩家1
  */
class player1Actor(val p2: ActorRef) extends Actor{
  // receive方法是负责处理消息的
  override def receive: Receive = {
    case "start" => {
      println("棋圣：I'm OK !")
      p2 ! "该你了"
    }
    case "将军" => {
      println("棋圣：你真猛!")
      Thread.sleep(1000)
      p2 ! "该你了"
    }
  }
}
