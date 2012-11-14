package com.google.webserg.scala.functions

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 3/3/11 12:03 AM
 */

object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg <- args.drop(1) )
      LongLinesLocal.processFile(arg, width)
  }
}