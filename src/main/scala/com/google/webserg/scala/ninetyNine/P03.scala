package com.google.webserg.scala.ninetyNine

// P03 (*) Find the Kth element of a list.
//     By convention, the first element in the list is element 0.
//
//     Example:
//     scala> nth(2, List(1, 1, 2, 3, 5, 8))
//     res0: Int = 2

object P03 extends App {
  // Trivial with builtins.
  def nthBuiltin[A](n: Int, ls: List[A]): A = ls(n)

  assert(nthBuiltin(2, List(1, 1, 2, 3, 5, 8)) == 2)

  def nthNonRec[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _) => h
    case (n, _ :: tail) => nthNonRec(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  assert(nthNonRec(2, List(1, 1, 2, 3, 5, 8)) == 2)
}