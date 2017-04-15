package com.google.webserg.scala.collections

object combinatorialSearch {
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

  //> isPrime: (n: Int)Boolean
  //second prime number beetwen 1000 and 10000
  ((1000 to 10000) filter isPrime) (1) //> res0: Int = 1013
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
  //> xs  : Stream.Cons[Int] = Stream(1, ?)
  val xxs = Stream(1, 2, 3) //> xxs  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  (1 to 10).toStream //> res1: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  } //> streamRange: (lo: Int, hi: Int)Stream[Int]
  def listRange(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi) Nil
    else lo :: listRange(lo + 1, hi)
  } //> listRange: (lo: Int, hi: Int)List[Int]
  ((1000 to 10000).toStream filter isPrime) (1) //> res2: Int = 1013
}