package com.google.webserg.scala.expressions

/**
  * Scala's if can result in a value
  */

object IfExample {
  def main(args: Array[String]) {
    //old style
    var filename = "default.txt"
    if (!args.isEmpty)
      filename = args(0)
    //new style
    val filename2 =
      if (!args.isEmpty) args(0)
      else "default.txt"

    println(filename)
    println(filename2)
    println(if (!args.isEmpty) args(0) else "default.txt")

    val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund", "Scottish Terrier", "Great Dane",
      "Portuguese Water Dog")

    for (breed <- dogBreeds
         if breed.contains("Terrier");
         if !breed.startsWith("Yorkshire")
    ) println(breed)
  }
}