package com.google.webserg.scala.ninetyNine

object repl1_10 extends App {
  // Find the last element of a list.	
  def last(l: List[Int]) = {
    println(l.last)
  }

  last(List(1, 2, 3))

  //Find the last but one element of a list.
  //penultimate(List(1, 1, 2, 3, 5, 8)) => 5
  def penultimate(l: List[Int]) = {
    l.reverse.tail.head
  }

  assert(5 == penultimate(List(1, 1, 2, 3, 5, 8)))


  object ::> {
    def unapply[A](l: List[A]) = Some((l.init, l.last))
  }

  List(1, 2, 3) match {
    case _ ::> last => println(last)
  }

  //Find out whether a list is a palindrome. scala> isPalindrome(List(1, 2, 3, 2, 1))
  def listPat(list: List[Int]): Boolean = list match {
    case List(_) => true
    case Nil => false
    case first :: (l ::> last) => if (first == last) listPat(l) else false
  }

  assert(listPat(List(1, 2, 3, 2, 1)))
  assert(!listPat(List(1, 2, 3, 2, 1, 3)))

  // Find the last element of a list.

}