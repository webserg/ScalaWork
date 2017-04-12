package com.google.webserg.scala

/**
  * User: sedo
  * Date: 01.nov.2010
  *
  */

object Factorial {

  def factorial(x: Int): Int =
    if (x == 0) 1 else x * this.factorial(x - 1)

  /**
    * tail recursion
    */
  def factWithTailRecurcion(x: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)

    loop(1, x)
  }

  def main(args: Array[String]) {
    println(factorial(5))
    println(factWithTailRecurcion(5))
    assert(factorial(5) == factWithTailRecurcion(5))
  }
}