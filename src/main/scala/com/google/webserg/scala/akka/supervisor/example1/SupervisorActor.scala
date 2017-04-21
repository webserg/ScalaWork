package com.google.webserg.scala.akka.supervisor.example1

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorLogging, ActorRef, AllForOneStrategy, Props}

import scala.concurrent.duration.Duration

class SupervisorActor extends Actor with ActorLogging {

  import akka.actor.SupervisorStrategy._

  val workerActor1: ActorRef = context.actorOf(Props[WorkerActor1], name = "workerActor1")
  val workerActor2: ActorRef = context.actorOf(Props[WorkerActor2], name = "workerActor2")

  override val supervisorStrategy: AllForOneStrategy = AllForOneStrategy(maxNrOfRetries = 10, withinTimeRange = Duration.create(3, TimeUnit.SECONDS)) {

    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }

  def receive: PartialFunction[Any, Unit] = {
    case GiveMeResult =>
      workerActor1.tell(GiveMeResult, sender)
    case msg: Int =>
      workerActor1 ! msg

  }
}