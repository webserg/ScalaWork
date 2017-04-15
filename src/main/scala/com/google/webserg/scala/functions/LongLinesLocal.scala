package com.google.webserg.scala.functions

import scala.io.Source

/**
  * @author Sergiy Doroshenko
  *         email:webserg@gmail.com
  *         Date: 3/26/11 11:22 PM
  *
  *         In this example, we refactored the original LongLines version, shown in
  *         , by transforming private method, processLine, into a local function
  *         of processFile. To do so we removed the private modifier, which can
  *         only be applied (and is only needed) for methods, and placed the definition
  *         of processLine inside the definition of processFile. As a local function,
  *         processLine is in scope inside processFile, but inaccessible outside.
  */

object LongLinesLocal {
  def processFile(filename: String, width: Int) {
    def processLine(filename: String, width: Int, line: String) {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }


}