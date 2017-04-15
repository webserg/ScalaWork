package com.google.webserg.scala.functions

object HighOrderFunc extends App {
  // sum of all elements between a and b
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  //curring, function that returns another function
  def sum2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  }

  /*curring with syntax shugar, function that returns another function so important that has special syntax
   * sum3 equivalent sum2
   */
  def sum3(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum3(f)(a + 1, b)

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  def sumAndProduct(f: Int => Int)(a: Int, b: Int, k: (Int, Int) => Int, x: Int): Int =
    if (a > b) x
    else k(f(a), sumAndProduct(f)(a + 1, b, k, x))

  product(x => x * x)(3, 4)
  println(sum(x => x * x, 1, 5))

  def cube(x: Int) = x * x * x

  println(sum2(x => x * x)(1, 5))
  println(sum2(cube)(1, 5))

}