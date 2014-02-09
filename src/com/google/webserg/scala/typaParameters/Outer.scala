package com.google.webserg.scala.typaParameters

class Outer {
  trait Inner
  def y = new Inner {}
  def foo(x : this.Inner) = println("foo")
  def bar(x : Outer#Inner) = println("bar")
}

object OuterTest extends App{
  val x = new Outer
  val y = new Outer
  x.foo(x.y)
  x.foo(x.y)
//  x.foo(y.y)
  x.bar(y.y)
}
