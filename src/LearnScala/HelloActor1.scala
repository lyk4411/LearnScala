package LearnScala

/**
  * Created by lyk on 2019-11-20.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor1 extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _       => println("huh?")
  }
}

object HelloApp extends App {
  override def main(args: Array[String]){
    val system = ActorSystem("HelloSystem")
    // default Actor constructor
    val HelloActor1 = system.actorOf(Props[HelloActor1], name = "HelloActor1")
    HelloActor1 ! "hello"
    HelloActor1 ! "buenos dias"
    while (true){
      HelloActor1 !  Console.readLine
    }
  }
}