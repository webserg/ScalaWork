package com.google.webserg.scala.akka.mapReduce
import java.util.ArrayList
import java.util.HashMap

import scala.collection.JavaConversions.asScalaBuffer

import akka.actor.actorRef2Scala
import akka.actor.Actor
import akka.actor.ActorRef

class ReduceActor(aggregateActor: ActorRef) extends Actor {

	def receive: Receive = {
		case message: MapData =>
			aggregateActor ! reduce(message.dataList)
		case _ =>

	}

	def reduce(dataList: ArrayList[Word]): ReduceData = {
		val reducedMap = new HashMap[String, Integer]
		for (wc:Word <- dataList) {
			val word: String = wc.word
			if (reducedMap.containsKey(word)) {
				reducedMap.put(word,reducedMap.get(word)+1 )
			} else {
				reducedMap.put(word, 1)
			}
		}
		new ReduceData(reducedMap)
	}
}