package com.google.webserg.scala.ninetyNine

/*
 * Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */
object P02 extends App {
  def penultimate(l: List[Int]) = l.reverse.tail.head

  assert(penultimate(List(1, 1, 2, 3, 5, 8)) == 5)

  // Again, with builtins this is easy.
  def penultimateBuiltin[A](ls: List[A]): A =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  assert(penultimateBuiltin(List(1, 1, 2, 3, 5, 8)) == 5)

  // But pattern matching also makes it easy.
  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException()
  }

  assert(penultimateRecursive(List(1, 1, 2, 3, 5, 8)) == 5)
}