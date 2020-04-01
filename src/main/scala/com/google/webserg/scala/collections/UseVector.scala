package com.google.webserg.scala.collections

object UseVactor extends App {
  def scalaProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
    (xs zip ys) map (xy => xy._1 * xy._2) sum
  }

  def scalaProduct2(xs: Vector[Double], ys: Vector[Double]): Double = {
    (xs zip ys) map { case (x, y) => x * y } sum

  }

  def scalaProduct3(xs: List[Double], ys: List[Double]): Double = {
    (for {i <- 0 until xs.length} yield (xs(i) * ys(i))) sum
  }

  def scalaProduct4(xs: List[Double], ys: List[Double]): Double = {
    (for {(i, j) <- (xs zip ys)} yield (i * j)) sum
  }

  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

  println(scalaProduct(Vector(1, 2, 3), Vector(4, 5, 6)))
  println(scalaProduct3(List(1, 2, 3), List(4, 5, 6)))

  var v = Vector(1, 2, 3, 9, 11)
  println(v(0))
  v = v.drop(9)
  println(v)
}