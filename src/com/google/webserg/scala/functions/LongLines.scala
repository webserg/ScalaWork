package com.google.webserg.scala.functions

import scala.io.Source

/**
  * @author Sergiy Doroshenko
  *         email:webserg@gmail.com
  *         Date: 3/2/11 11:58 PM
  */

object LongLines {

  def processFile(filename: String, width: Int) {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }

  private def processLine(filename: String, width: Int, line: String) {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }

}