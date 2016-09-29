package com.google.webserg.scala.expressions


object ForEx extends App {
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines.toList

  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(
        file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

  //--------------------------------------------
  val filesHere = (new java.io.File("./src/com/google/webserg/scala/expressions")).listFiles
  //for (file <- filesHere if file.getName.endsWith(".scala"))
    //println(file)
  //------------------------------------------

  grep("package com.google.webserg.scala.expressions")
}