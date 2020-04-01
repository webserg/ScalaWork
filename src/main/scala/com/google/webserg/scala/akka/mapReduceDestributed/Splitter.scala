package com.google.webserg.scala.akka.mapReduceDestributed

import akka.actor.Actor

/**
  * Created by webse on 5/12/2017.
  */
class Splitter extends Actor {
  override def receive: Receive = {
    case inputData: InputData =>
  }
}

object Splitter {
  def split(path:String): List[String] = {
    import java.io.RandomAccessFile
    val raf = new RandomAccessFile(path, "r")
    List()
  }
}
