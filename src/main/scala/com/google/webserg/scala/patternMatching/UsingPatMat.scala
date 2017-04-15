package com.google.webserg.scala.patternMatching

/**
  * Created by webse on 3/27/2017.
  */
object UsingPatMat extends App {

  /**
    * val f  = {    case "ping" => "pong"  }
    *
    * doesnt work it needs type from out side
    */

  val f: String => String = {
    case "ping" => "pong"
  }

  println(f("ping"))
  //println(f("gol")) // error

  //it would be good to know if function applicable

  val f1: PartialFunction[String, String] = {
    case "ping" => "pong"

  }
  println(f1.isDefinedAt("ping"))
  println(f1.isDefinedAt("gol"))

  println(f1("ping"))

}
