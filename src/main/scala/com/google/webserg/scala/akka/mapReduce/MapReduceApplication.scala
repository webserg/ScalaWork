package com.google.webserg.scala.akka.mapReduce

import java.util
import java.util.ArrayList
import java.util.HashMap

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala


class Word(val word: String, val count: Integer)

case class Result()

class MapData(val dataList: util.ArrayList[Word])

class ReduceData(val reduceDataMap: util.HashMap[String, Integer])

/*
Herbert_Frank_-_Dune_1_-_Dune
* */
object MapReduceApplication {
//  type Word = String

  def main(args: Array[String]) {
    val _system = ActorSystem("MapReduceApp")
    val master = _system.actorOf(Props[MasterActor], name = "master")

    master ! "The quick brown fox tried to jump over the lazy dog and fell on the dog"
    master ! "Dog is man's best friend"
    master ! "Dog and Fox belong to the same family"

    Thread.sleep(500)
    master ! new Result

    Thread.sleep(500)
    _system.terminate()
  }
}