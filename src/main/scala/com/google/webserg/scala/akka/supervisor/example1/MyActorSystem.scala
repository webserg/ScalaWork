package com.google.webserg.scala.akka.supervisor.example1

import java.util.concurrent.TimeUnit

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration.Duration


object MyActorSystem extends App {

  val system = ActorSystem("faultTolerance")
  val log = system.log
  val originalValue: Int = 0

  val supervisor = system.actorOf(Props[SupervisorActor], name = "supervisor")

  log.info("Sending value 8, no exceptions should be thrown! ")
  var mesg: Int = 8
  supervisor ! mesg

  supervisor ! 12
  implicit val timeout = Timeout(Duration.create(5, TimeUnit.SECONDS))
  var future = supervisor ? GiveMeResult
  var result = Await.result(future, timeout.duration).asInstanceOf[Int]

//  log.info("Value Received->" + result)

  log.info("Sending value -8, ArithmeticException should be thrown! Our Supervisor strategy says resume !")
  mesg = -8
  supervisor ! mesg

  future = supervisor ? GiveMeResult
  result = Await.result(future, timeout.duration).asInstanceOf[Int]

  log.info("Value Received->" + result)

  log.info("Sending value null, NullPointerException should be thrown! Our Supervisor strategy says restart !")
  supervisor ! new NullPointerException

  future = supervisor ? GiveMeResult
  result = Await.result(future, timeout.duration).asInstanceOf[Integer]

  log.info("Value Received->" + result)

  log.info("Sending value \"String\", IllegalArgumentException should be thrown! Our Supervisor strategy says Stop !")

  supervisor ? "Do Something"

  log.info("Worker Actors shutdown !")

  system.terminate()

}