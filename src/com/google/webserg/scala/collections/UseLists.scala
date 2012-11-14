package com.google.webserg.scala.collections

/**
 * User: serg
 * Date: Nov 14, 2010
 * Time: 8:29:01 PM
 */
/*
 * lists are immutable
 * lists are recursive while arrays are flat
 */
object UseLists extends App {

  val oneTwo = List(1, 2) // lists are immutable
  println(oneTwo(0))
  println(oneTwo.exists(x => x == 1))
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour
  println("" + oneTwo + " and " + threeFour + " were not mutated.!")
  println("Thus, " + oneTwoThreeFour + " is a new list.")
  /*::, which
    is pronounced cons. Cons prepends a new element to the beginning of an
    existing list, and returns the resulting list.*/
  val oneTwoThree = 1 :: 2 :: 3 :: Nil
  println(oneTwoThree head)
  // val oneTwoThree = List(oneTwoThree, Nil)
  println(oneTwoThree)
  //If the method name ends in a colon, the method is invoked on the right operand. !!!!!
  val list = 5 :: oneTwoThree
  println(list)

  val a = List(2, 3, 5, 7, 11)
  val result = for (elem <- a) yield 2 * elem
  // result is Array(4, 6, 10, 14, 22)
  println(result)
  val res2 = a map { 2 * _ }
  println(res2)

  val dig3 = List(List(1, 2, 3), List(1, 2, 3), List(1, 2, 3))
  val n: List[Nothing] = List()
  val n2 = Nil

  def listMatch(list: List[Any]): List[Any] = list match {
    case x :: y :: List(xs, ys) :: zs => list //List(List(1,2),List(1,2),List(1,2))
    case 1 :: 2 :: xs => list // list starts 1 2
    case x :: Nil => list //list of lenghts 1 List(x) the same
    case List(2 :: xs) => xs //list contain	s another list starts with 2
    case p :: ps => ps // p head ps tail
    // case Nil => list

    case List() => list

  }

  println(listMatch(a))

  println(listMatch(1 :: 2 :: 3 :: Nil))
  /**
   * complesity is N * N
   */
  def isort(list: List[Int]): List[Int] = list match {
    case List() => list
    case x :: xs => insert(x, isort(xs))
  }

  def insert(head: Int, ls: List[Int]): List[Int] = ls match {
    case List() => List(head)
    case x :: xs => if (head <= x) head :: ls else x :: insert(head, xs)
  }
  println(isort(18 :: 4 :: 9 :: 7 :: Nil))

  def last[T](list: List[T]): T = list match {
    case List() => throw new Error("last element of list")
    case List(x) => x
    case y :: ys => last(ys)
  }
  //all elem f list except last one
  def init[T](list: List[T]): List[T] = list match {
    case List() => throw new Error("last element of list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def revers[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case z :: zs => revers(zs) ::: List(z)
  }

  def removeAt[T](xs: List[T], n: Int): List[T] = {
    def removeAt0[T](ys: List[T], count: Int): List[T] = ys match {
      case z :: zs => if (n == count) zs else z :: removeAt0(zs, count + 1)
    }
    if (xs.length < n) xs
    else removeAt0(xs, 0)
  }

  def removeAtList[T](xs: List[T], n: Int): List[T] = (xs take n) ::: (xs drop n + 1)

  println(last(18 :: 4 :: 9 :: 7 :: Nil))
  println(init(18 :: 4 :: 9 :: 7 :: Nil))
  println(concat(18 :: 4 :: 9 :: 7 :: Nil, 4 :: 6 :: 12 :: Nil))
  println(revers(18 :: 4 :: 9 :: 7 :: 4 :: 6 :: 12 :: Nil))
  println(removeAt(1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: Nil, 2))
  assert(removeAt(1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: Nil, 2) == removeAtList(1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: Nil, 2))
  println("take 1 " + (1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: Nil take 3)) //first n elem
  println("drop 3 " + (1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: Nil drop 3)) //last elem after n

  //merge sort

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {

      val (fst, snd) = xs splitAt n
      merge1(msort(fst), msort(snd))
    }
  }
  //uneffitiant
  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    xs match {
      case Nil => ys
      case x :: xs1 =>
        ys match {
          case Nil => xs
          case y :: ys1 =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
    }
  //more efficiant
  def merge1(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (List(), ys) => ys
    case (xs, List()) => xs
    case (x :: xs1, y :: ys1) => if (x < y) x :: merge1(xs1, ys)
    else y :: merge1(xs, ys1)
  }

  println(msort(1 :: 12 :: 8 :: 4 :: 5 :: 6 :: 7 :: Nil))

  def msortParam[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def mergeParam(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: mergeParam(xs1, ys) else y :: mergeParam(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      mergeParam(msortParam(fst)(lt), msortParam(snd)(lt))
    }
  }

  println(msortParam(1 :: 12 :: 8 :: 4 :: 5 :: 6 :: 7 :: Nil)((x, y) => x < y))
  
  // List(('a', 2), ('b', 2), ('c', 1), ('d', 1), ('e', 1))('a', 2)
}