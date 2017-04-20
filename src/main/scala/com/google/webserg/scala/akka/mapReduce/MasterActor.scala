package com.google.webserg.scala.akka.mapReduce
import akka.actor.actorRef2Scala
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props


class MasterActor extends Actor {
	
	val aggregateActor:ActorRef = context.actorOf(Props[AggregateActor],name="aggregate")
	val reduceActor:ActorRef = context.actorOf(Props(new ReduceActor(aggregateActor)),name="reduce")
	val mapActor:ActorRef = context.actorOf(Props(new MapActor(reduceActor)),name="map")

		def receive: Receive = {
		case message: String =>
			mapActor ! message
		case message:Result =>
			aggregateActor ! message
		case _ =>
	}
}