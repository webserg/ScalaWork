package com.google.webserg.scala.generics

//A <: Ordered[A] introduces A as a type parameter
//which must be a subtype of Ordered[A],

class EmptySet[A <: Ordered[A]] extends Set[A] {
  def contains(x: A): Boolean = false
  def incl(x: A): Set[A] = new NonEmptySet(x, new EmptySet[A], new EmptySet[A])
}
