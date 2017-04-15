package com.google.webserg.scala.algorithms

/**
  * Created by webse on 4/9/2017.
  */

import scala.math.Ordering.Implicits._


/**
  * collection of algorithms related to combinatorics
  */
object Combinatorics extends App {

  // TODO: make these implicit methods .combinations, .combinations(n) etc

  /**
    * Iterate over all 2^n combinations - Different from the Scala Collection's combinations...
    *
    *
    * @param s sequence to do combination over
    * @return all 2^n ways of choosing elements from s
    **/
  def combinations[A](s: Seq[A]) = for {i <- 0 to s.length; j <- s combinations i} yield j

  /**
    * Combinations with repeats e.g. (2, Set(A,B,C)) -> AA, AB, AC, BA, BB, BC, CA, CB, CC
    *
    * @return all s.length^n combinations
    **/
  def repeatedCombinations[A](s: Set[A], n: Int): Traversable[List[A]] = n match {
    case 0 => List(Nil)
    case _ => for {(x, xs) <- s X repeatedCombinations(s, n - 1)} yield x :: xs
  }

  implicit class Crossable[A](as: Traversable[A]) {
    def X[B](bs: Traversable[B]) = for {a <- as; b <- bs} yield (a, b)
  }


  /**
    * Generates all n^s.length combinations
    * O(n)
    * Think of as instead of boolean (2 states), we have n states for each cell in s
    * Also, equivalent to adding 1 in base n
    * Call with initially all zeroes in s
    *
    *
    * @return next combination of n
    */
  def nextCombination(s: Seq[Int], n: Int): List[Int] = s match {
    case Nil => Nil
    case x :: xs if x < 0 || x >= n => throw new IllegalArgumentException
    case x :: xs if x == n - 1 => 0 :: nextCombination(xs, n)
    case x :: xs => x + 1 :: xs
  }


  private[this] implicit def toBigInt(i: Int): BigInt = BigInt(i)

  println(repeatedCombinations[String](Set("A", "B", "C"), 2))

}

