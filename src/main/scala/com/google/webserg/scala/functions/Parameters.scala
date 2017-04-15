package com.google.webserg.scala.functions

/*
 * called-by-value
 * sumOfSquares(3, 2+2)
! sumOfSquares(3, 4)
! square(3) + square(4)
! 3 * 3 + square(4)
! 9 + square(4)
! 9 + 4 * 4
! 9 + 16
! 25
called-by-name
sumOfSquares(3, 2+2)
! square(3) + square(2+2)
! 3 * 3 + square(2+2)
! 9 + square(2+2)
! 9 + (2+2) * (2+2)
! 9 + 4 * (2+2)
! 9 + 4 * 4
! 9 + 16
! 25

Scala uses call-by-value by default, but it switches to call-by-name evaluation if the
parameter type is preceded by =>.
 */
object Parameters extends App {
  def square(x: Double) = x * x

  def sumOfSquare(x: Double, y: Double) = square(x) + square(y)

  def loop: Int = loop

  def constOne(x: Int, y: => Int) = 1

  println(constOne(1, loop)) //1 called-by-name

  //	println(constOne(loop,1)) // gives us infinite loop
}
