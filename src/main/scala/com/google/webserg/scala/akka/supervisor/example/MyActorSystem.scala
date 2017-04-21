package com.google.webserg.scala.akka.supervisor.example

import akka.actor.{ActorRef, ActorSystem, Props}

case class Result()
case class DeadWorker()
case class RegisterWorker(worker: ActorRef, supervisor: ActorRef)

object MyActorSystem extends App {

  val system = ActorSystem("faultTolerance")
  val log = system.log

  val supervisor = system.actorOf(Props[SupervisorActor], name = "supervisor")

  val mesg: Int = 8
  supervisor ! mesg

  supervisor ! "Do Something"

  Thread.sleep(4000)

  supervisor ! mesg

  system.terminate()

}