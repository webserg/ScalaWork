package com.google.webserg.scala.akka.hello

/**
  * Created by webse on 4/20/2017.
  */
object DirReader extends App{
  def read() = {
    new java.io.File(".\\src\\main\\resources").listFiles() foreach  (println(_))
//    new java.io.File(".\\src\\main\\resources").listFiles() foreach { f =>
//      for (line <- scala.io.Source.fromFile(f).getLines) {
//        println(line)
//      }
//
//    }
  }
  read()
}
