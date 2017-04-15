package com.google.webserg.scala.functions

/**
  * @author Sergiy Doroshenko
  *         email:webserg@gmail.com
  *         Date: 3/27/11 12:41 AM
  */

object FirstClassFunc extends App {
  def sum(a: Int, b: Int, c: Int) = a + b + c

  val someNumbers = List(11, 10, 5, 0, 5, 10)
  println(someNumbers.filter((x: Int) => x > 0))
  println(someNumbers.filter((x) => x > 0)) //consice
  println(someNumbers.filter(x => x > 0)) //consice
  println(someNumbers.filter(_ > 0)) //consice

  val a = sum _
  println(sum(1, 2, 3))

}