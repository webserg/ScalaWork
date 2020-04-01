package com.google.webserg.scala.akka.mapReduceDestributed

import akka.actor.{Actor, ActorRef, Props, actorRef2Scala}


class Master extends Actor {
	
	val reduceer:ActorRef = context.actorOf(Props(new Reducer()),name="reducer")
	val maper:ActorRef = context.actorOf(Props(new Mapper()),name="mapper")

		def receive: Receive = {
		case message: String =>
			maper ! message
		case _ =>
	}
}