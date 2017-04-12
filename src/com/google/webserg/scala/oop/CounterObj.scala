package com.google.webserg.scala.oop

/*
Sometimes, however, you want a property that a client can't set at will, but that is mutated
some other way. The Counter class from Section 1 is a good example. Conceptually, the
counter has a current property that is updated when the increment method is called, but
there is no setter for the property.
You can't implement such a property with a val—a val never changes. Instead, provide a
private field and a property getter, like this:
*/
class Counter {
  private var value: Int = 0

  def inc() {
    value += 1
  }

  def current = value
}

object CounterObj extends App {
  val n = new Counter
  n.inc()
  //println(n.current()) // you can't use current() because it was defined without parences
}