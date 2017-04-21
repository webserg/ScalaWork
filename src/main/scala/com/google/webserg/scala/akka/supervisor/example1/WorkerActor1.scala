package com.google.webserg.scala.akka.supervisor.example1

import akka.actor.{Actor, ActorLogging, actorRef2Scala}
import com.google.webserg.scala.akka.supervisor.example1.MyActorSystem.log

class WorkerActor1 extends Actor with ActorLogging {

  var state: Int = 0;

  override def preStart() {
    log.info("Starting WorkerActor instance hashcode #" + this.hashCode());
  }
  override def postStop() {
    log.info("Stopping WorkerActor instance hashcode #" + this.hashCode());
  }
  def receive: Receive = {
    case value: Int =>
      if (value <= 0)
        throw new ArithmeticException("Number equal or less than zero");
      else
        log.info("state is->" + value)
        state = value;
    case GiveMeResult =>
      log.info("send result to ->" + sender)
      sender ! state
    case ex: NullPointerException =>
      throw new NullPointerException("Null Value Passed");
    case _ =>
      throw new IllegalArgumentException("Wrong Argument");
  }
}