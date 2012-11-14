package com.google.webserg.scala.refactoring

object FileMatcher2 {

  private def filesHere = (new java.io.File("c:\\scala\\ScalaWork\\src\\com\\google\\webserg\\scala")).listFiles
  
  private def filesMatching(matcher: String => Boolean) =
    for (
      file <- filesHere;
      if matcher(file.getName)
    ) yield file

    //_.endsWith(_) the same (fileName: String, query: String) => fileName.endsWith(query)
    
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  def main(args: Array[String]): Unit = {
    filesEnding(".scala").foreach(println(_))
    println("-----------------------------")
    filesContaining("Tuples").foreach(println(_))
    println("-----------------------------")
    filesRegex("%T%").foreach(println(_))

    }

}