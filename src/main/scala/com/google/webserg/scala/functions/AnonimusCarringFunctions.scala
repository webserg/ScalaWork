package com.google.webserg.scala.functions

object AnonimusCarringFunctions extends App {

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  def t(x: Int): Int = x + 1

  def sum2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)

    sumF
  }

  println(sum(t)(1, 2))
  println(sum2(t)(1, 2))

  //====================================================

  def add(a: Int)(b: Int) = "result is:" + (a + b)

  def add2(a: Int): (Int) => String = {
    def addF(b: Int) =
      "result is:" + (a + b)

    addF
  }

  println(add(1)(2))
  println(add2(1)(2))
}