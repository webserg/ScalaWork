package com.google.webserg.scala.expressions

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 4/2/11 11:34 PM
 */

object ForYield extends App {
  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

   val filesHere = (new java.io.File("./src/com/google/webserg/scala/expressions")).listFiles

  println(scalaFiles(2))
}