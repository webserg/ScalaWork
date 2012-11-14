package com.google.webserg.scala.useTrait

/**
 * Bluegarden
 * User: sedo
 * Date: 2/23/11
 * Traits are a fundamental unit of code reuse in Scala. A trait encapsulates
method and field definitions, which can then be reused by mixing them into
classes. Unlike class inheritance, in which each class must inherit from just
one superclass, a class can mix in any number of traits.

 */

trait Philosophical {
  def philosophize() {
    println("I consume memory, therefore I am!")
    println(super.toString)
  }
}