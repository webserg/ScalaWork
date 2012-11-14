package com.google.webserg.scala.actors

import scala.actors.Actor._
import actors.Actor

/**
 * Created by sergiy.doroshenko
 * Date: 5/18/11
 *
 * scala console run
 * > com.google.webserg.scala.actors.NameResolver.start
 * > com.google.webserg.scala.actors.NameResolver ! ("www.scalalang.org", self)
 * >
 */

object NameResolver extends Actor {

  import java.net.{InetAddress, UnknownHostException}

  def act() {
    react {
      case (name: String, actor: Actor) =>
        println("handle")
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver exiting.")
        //quit
      case msg =>
        println("Unhandled message: " + msg)
        act()
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
     val ip =  Some(InetAddress.getByName(name))
      println(ip)
      ip
    } catch {
      case _: UnknownHostException => None
    }
  }

  def main(args: Array[String]) {
     start()
    //com.google.webserg.scala.actors.NameResolver ! "www.scalalang.org"
    com.google.webserg.scala.actors.NameResolver ! ("www.scala-lang.org", self)
    com.google.webserg.scala.actors.NameResolver ! ("google.com", self)
  }
}