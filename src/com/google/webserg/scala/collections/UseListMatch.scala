package com.google.webserg.scala.collections

/**
  * Created by webse on 2/21/2017.
  */
object UseListMatch extends App {
  def listMatch(list: List[Any]): List[Any] = list match {
    case x :: y :: List(xs, ys) :: zs => list //List(List(1,2),List(1,2),List(1,2))
    case 1 :: 2 :: xs => list // list starts 1 2
    case x :: Nil => list //list of lenghts 1 List(x) the same
    case List(2 :: xs) => xs //list contain	s another list starts with 2
    case p :: ps => ps // p head ps tail
    // case Nil => list

    case List() => list

  }

  val a = List(2, 3, 5, 7, 11)
  println(listMatch(a))

  println(listMatch(1 :: 2 :: 3 :: Nil))

  def listMatchChar(acc: Int, list: List[Char]): Boolean = {
    list match {
      case '(' :: xs => listMatchChar(acc + 1, xs)
      case ')' :: xs => listMatchChar(acc - 1, xs)
      case _ :: xs => listMatchChar(acc, xs)
      case List() => acc == 0
    }
  }

  val s = "balance: '(if (zero? x) max (/ 1 x))' is balanced"
  println(listMatchChar(0, s.toList))
  //  println(listMatch(1 :: 2 :: 3 :: Nil))
}
