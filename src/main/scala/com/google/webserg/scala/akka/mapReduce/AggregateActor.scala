package com.google.webserg.scala.akka.mapReduce

import java.util
import java.util.HashMap

import scala.collection.JavaConversions.asScalaSet
import akka.actor.Actor

class AggregateActor extends Actor {

	var finalReducedMap = new util.HashMap[String, Integer]

	def receive: Receive = {
		case message: ReduceData =>
			aggregateInMemoryReduce(message.reduceDataMap)
		case message: Result =>
			System.out.println(finalReducedMap.toString)
	}

	def aggregateInMemoryReduce(reducedList: util.HashMap[String, Integer]) {
		var count: Integer = 0
		for (key <- reducedList.keySet) {
			if (finalReducedMap.containsKey(key)) {
				count = reducedList.get(key)
				count += finalReducedMap.get(key)
				finalReducedMap.put(key, count)
			} else {
				finalReducedMap.put(key, reducedList.get(key))
			}
		}
	}
}