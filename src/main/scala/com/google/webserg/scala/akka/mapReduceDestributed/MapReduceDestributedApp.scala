package com.google.webserg.scala.akka.mapReduceDestributed

import akka.actor.{ActorSystem, Props}
import com.google.webserg.scala.akka.mapReduce.MasterActor

case class Word(word: String, count: Integer)

case class Result()

case class MapData()

case class InputData(filePath: String)
case class SplittedData(filePath: String)

/**
  * Created by webse on 5/12/2017.
  */
object MapReduceDestributedApp {
  def main(args: Array[String]) {
    val _system = ActorSystem("MapReduceApp")
    val master = _system.actorOf(Props[MasterActor], name = "master")
    master ! InputData("C:\\devel\\ScalaWork\\src\\main\\resources\\Herbert_Frank_-_Dune_1_-_Dune.txt")
  }

}
