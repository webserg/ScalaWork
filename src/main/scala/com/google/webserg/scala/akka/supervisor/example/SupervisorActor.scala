package com.google.webserg.scala.akka.supervisor.example

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorLogging, Props}

import scala.concurrent.duration.Duration

class SupervisorActor extends Actor with ActorLogging {
  import akka.actor.OneForOneStrategy
  import akka.actor.SupervisorStrategy._

  var childActor = context.actorOf(Props[WorkerActor], name = "workerActor")
  val monitor = context.system.actorOf(Props[MonitorActor], name = "monitor")

  override def preStart() {
    monitor ! new RegisterWorker(childActor, self)
  }

  override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = Duration.create(10, TimeUnit.SECONDS)) {

    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }

  def receive = {
    case result: Result =>
      childActor.tell(result, sender)
    case mesg: DeadWorker =>
      log.info("Got a DeadWorker message, restarting the worker")
      childActor = context.actorOf(Props[WorkerActor], name = "workerActor")
    case msg: Object =>
      childActor ! msg
  }
}