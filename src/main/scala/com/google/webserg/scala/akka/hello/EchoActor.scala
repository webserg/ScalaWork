package com.google.webserg.scala.akka.hello
import akka.actor.Actor

class EchoActor extends Actor {
  var messageProcessed:Int = 0

  def receive: Receive = {
    case message =>
      messageProcessed = messageProcessed + 1
      println(
        "Received Message %s in Actor %s using Thread %s, total message processed %s".format( message,
          self.path.name, Thread.currentThread().getName, messageProcessed))
  }
}
