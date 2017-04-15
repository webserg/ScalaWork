package com.google.webserg.scala.generics

//View bounds <% are weaker than plain bounds <:: A view bounded type parameter
//clause [A <% T] only specifies that the bounded type A must be convertible to the
//bound type T, using an implicit conversion.

class NonEmptySet[A <% Ordered[A]] // param A subtype of Ordered[A]
(elem: A, left: Set[A], right: Set[A]) extends Set[A] {
  def contains(x: A): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: A): Set[A] =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
}