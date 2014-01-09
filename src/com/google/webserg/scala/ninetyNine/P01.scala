package com.google.webserg.scala.ninetyNine
// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8

// The start of the definition of last should be
//     def last[A](l: List[A]): A = ...
// The `[A]` allows us to handle lists of any type.

//you can use underscores as
//placeholders for one or more parameters, so long as each parameter appears
//only one time within the function literal. For example, _ > 0 is very short
//notation for a function that checks whether a value is greater than zero:
//scala> someNumbers.filter(_ > 0)
//res7: List[Int] = List(5, 10)
object P01 extends App{
  // There are several ways to solve this problem.  If we use builtins, it's very
  // easy.
  def lastBuiltin[A](ls: List[A]): A = ls.last

  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _  => throw new NoSuchElementException()  
  }
  println(lastRecursive(List(1, 1, 2, 3, 5, 8)))
  

}