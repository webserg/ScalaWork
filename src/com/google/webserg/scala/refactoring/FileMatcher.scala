package com.google.webserg.scala.refactoring

object FileMatcher {

  private def filesHere = (new java.io.File("c:\\scala\\ScalaWork\\src\\com\\google\\webserg\\scala")).listFiles

  def filesEnding(query: String) =
    for (
      file <- filesHere;
      if file.getName.endsWith(query)
    ) yield file

  def filesContaining(query: String) =
    for (
      file <- filesHere;
      if file.getName.contains(query)
    ) yield file
    
  def filesRegex(query: String) =
    for (
      file <- filesHere;
      if file.getName.matches(query)
    ) yield file
    
  def main(args: Array[String]) {
    filesEnding(".scala").foreach(println(_))
    println("-----------------------------")
    filesContaining("Tupels").foreach(println(_))
    println("-----------------------------")
    filesRegex("Tupels").foreach(println(_))  
      
  }
}