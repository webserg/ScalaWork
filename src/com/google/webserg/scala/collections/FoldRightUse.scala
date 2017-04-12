package com.google.webserg.scala.collections

/*
 * ((A x B) x C) x D
 * foldl (-) [1, 2, 3] == (1 - 2) - 3 == 1 - 2 - 3 // - is left-associative
 * 
 * A x (B x (C x D))
 * foldr (::) [] [1, 2, 3] == 1 :: (2 :: (3 :: [])) == 1 :: 2 :: 3 :: [] == [1, 2, 3]
 */
object FoldRightUse extends App {
  val l1 = List(1, 2, 3, 4).foldRight(3)(_ + _) //== 1 :: (2 :: (3 :: [])) == 1 :: 2 :: 3 :: [] == [1, 2, 3]
  println(l1)
  val l3 = List(1, 2, 3, 4).foldLeft(3)(_ + _) //folds the same list using multiplication with a seed of 10, returning 7,200.
  println(l3)
}