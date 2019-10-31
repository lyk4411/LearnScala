package LearnScala

/**
  * Created by lyk on 2019-10-31.
  * Package name: LearnScala
  * Porject name: LearnScala
  */

import scala.actors.Actor

class myActor extends Actor {
  override def act(): Unit = {
    receive {
      case x:String => println("save String ="+ x)
      case x:Int => println("save Int")
      case _ => println("save default")
    }
  }
}

object Lesson_Actor {
  def main(args: Array[String]): Unit = {
    // 创建actor的消息接收和传递
    val actor =new myActor()
    // 启动
    actor.start()
    // 发送消息写法
    actor ! "i love you !"
  }
}