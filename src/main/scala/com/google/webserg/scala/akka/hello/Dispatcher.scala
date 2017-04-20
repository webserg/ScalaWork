package com.google.webserg.scala.akka.hello

import akka.actor.ActorSystem
import akka.actor.Props

/**
  * Created by webse on 4/20/2017.
  */
object Dispatcher {
  def main(args: Array[String]): Unit = {}

  val _system = ActorSystem.create("default-dispatcher")

  val actor = _system.actorOf(Props[MasterRouter])


  new java.io.File(".\\src\\main\\resources").listFiles() foreach { f =>
    for (line <- scala.io.Source.fromFile(f).getLines) {
      actor ! line
    }
  }
  _system.terminate
}
