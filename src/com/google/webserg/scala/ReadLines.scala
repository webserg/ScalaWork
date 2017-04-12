package com.google.webserg.scala

/**
  * User: Sergiy Doroshenko
  * Date: Nov 15, 2010 11:31:12 PM
  */

object ReadLines {
  def main(args: Array[String]) {
    import scala.io.Source
    if (args.length > 0) {
      for (line <- Source.fromFile(args(0)).getLines)
        print(line.length + " " + line)
    }
    else
      Console.err.println("Please enter filename")
  }
}