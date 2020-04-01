package com.google.webserg.scala.functions

/**
  * Created by webserg on 20.01.14.
  * In computer science, currying, invented by Moses
  * Schönfinkel and Gottlob Frege, is the technique of
  * transforming a function that takes multiple arguments
  * into a function that takes a single argument (the other
  * arguments having been specified by the curry).
  */
object FunctionCarring {
  /**
    * What this is saying is that the currying process transforms a function of two parameters into a function of one parameter
    * which returns a function of one parameter which itself returns the result.  In Scala, we can accomplish this like so:
    */
  def add(x: Int, y: Int) = x + y

  add(1, 2) // 3
  add(7, 3) // 10
  //after carrying
  def add(x: Int) = (y: Int) => x + y

  add(1)(2) // 3
  add(7)(3) // 10

  def add2(x: Int)(y: Int) = x + y

  add2(1)(2) // 3
  add2(7)(3) // 10
  add2(4)(_)

  /**
    * It turns out that the best rationale for using currying has to do with general and specialized functions.
    * It would be nice to define a function for the general case, but allow users to specialize the function
    * and then used the specialized version on different data sets.
    */
  def process[A](filter: A => Boolean)(list: List[A]): List[A] = {
    lazy val recurse = process(filter) _

    list match {
      case head :: tail => if (filter(head)) {
        head :: recurse(tail)
      } else {
        recurse(tail)
      }

      case Nil => Nil
    }
  }

  val even = (a: Int) => a % 2 == 0

  val numbersAsc = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
  val numbersDesc = 5 :: 4 :: 3 :: 2 :: 1 :: Nil

  process(even)(numbersAsc) // [2, 4]
  process(even)(numbersDesc) // [4, 2]


  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  def modN(n: Int)(x: Int) = (x % n) == 0

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))

}
