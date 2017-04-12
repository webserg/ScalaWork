package com.google.webserg.scala

/**
  * User: Sergiy Doroshenko
  * Date: Nov 21, 2010 10:04:08 PM
  */
/** The identifiers n and d in the parentheses after
  * the class name, Rational, are called class parameters. The Scala compiler
  * will gather up these two class parameters and create a primary constructor
  * that takes the same two parameters.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  //The Scala compiler will place the code for the initializers of Rational’s
  //three fields into the primary constructor in the order in which they appear
  //in the source code.
  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // auxiliary constructor
  //every auxiliary constructor must invoke another constructor of
  //the same class as its first action. In
  override def toString = numer + "/" + denom

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  //calculates the greatest common divisor of two passed Ints.
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}

object Rational {
  def main(args: Array[String]) {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)
    println(x + y)
  }
}