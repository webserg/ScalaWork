package com.google.webserg.scala.actors

import actors.Actor
import actors.Actor._

/**
 * Created by sergiy.doroshenko
 * Date: 5/17/11 
 */

object SeriousActor extends  Actor {
  def act() {
    while (true) {
      receive {
        case msg =>
          println("received message: " + msg)
          com.google.webserg.scala.actors.NameResolver ! ("google.com", com.google.webserg.scala.actors.NameResolver)
          com.google.webserg.scala.actors.NameResolver ! "EXIT"
          println("sent ")
      }
    }
  }

  def main(args: Array[String]) {
    start
    com.google.webserg.scala.actors.NameResolver.start
    com.google.webserg.scala.actors.SeriousActor ! "hello"

  }
}