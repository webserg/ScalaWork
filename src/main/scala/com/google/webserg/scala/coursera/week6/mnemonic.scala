package com.google.webserg.scala.coursera.week6

object mnemonic extends App {
  val mnemonic = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  def translate(phoneNumb: String): List[String] = {
    val pn = "7225247386"
    List(pn)
  }

  val pn = "7225247386"
  val res = "Scala is fun"

  def charCode: Map[Char, Char] = for ((k, v) <- mnemonic; c <- v) yield (c, k)

  println(charCode)
}