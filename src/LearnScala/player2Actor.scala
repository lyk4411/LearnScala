package LearnScala

/**
  * Created by lyk on 2019-11-19.
  * Package name: LearnScala
  * Porject name: LearnScala
  */


import akka.actor.{ActorSystem, Props}
import akka.actor.{Actor, ActorRef}

/**
  * 定义玩家2
  */
class player2Actor extends Actor{

  override def receive: Receive = {
    case "start" => println("棋仙说：I'm OK !")
    case "该你了" => {
      println("棋仙：那必须滴！")
      Thread.sleep(1000)
      /**
        * 注意，这个“sender()”，其实就是对ActorRef的一个引用。它指的是给发送"该你了"的这个对象本身！
        */
      sender() ! "将军"
    }
  }
}



object ChineseChess extends App{
  // 创建 actorSystem的工厂，用来生产ActorRef对象！
  private val ChineseChessActorSystem = ActorSystem("Chinese-chess")
  /**
    * 通过actorSystem创建ActorRef
    */
  private val p2 = ChineseChessActorSystem.actorOf(Props[player2Actor], "player2")            //创建player2Actor对象
  private val p1 = ChineseChessActorSystem.actorOf(Props(new player1Actor(p2)), "player1")   //创建player1Actor对象

  p2 ! "start"
  p1 ! "start"
}