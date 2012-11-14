package com.google.webserg.scala.actors

import actors.Actor
import io.BytePickle.Def

/**
 * Created by sergiy.doroshenko
 * Date: 5/17/11 
 */

object SillyActor extends Actor {

  def act() {
    for (i <- 1 to 5) {
      println("I'm acting!")
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]) {
    SillyActor.start
    SeriousActor.start
    com.google.webserg.scala.actors.SeriousActor ! "hello"
  }
}