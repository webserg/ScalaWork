package com.google.webserg.scala.akka.hello

import akka.actor.{Actor, Props, Terminated}
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}

/**
  * Created by webse on 4/20/2017.
  */
class MasterRouter extends Actor {
  var router: Router = {
    val routees = Vector.fill(5) {
      val r = context.actorOf(Props[EchoActor])
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  def receive: PartialFunction[Any, Unit] = {
    case w: String =>
      router.route(w, sender())
    case Terminated(a) =>
      router = router.removeRoutee(a)
      val r = context.actorOf(Props[EchoActor])
      context watch r
      router = router.addRoutee(r)
  }
}
