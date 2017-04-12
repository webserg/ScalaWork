package com.google.webserg.scala.useTrait.multiInheritnce

/**
  * Bluegarden
  * User: sedo
  * Date: 2/24/11
  *
  *
  */
/**
  * The Doubling trait has two funny things going on. The first is that it declares
  * a superclass, IntQueue. This declaration means that the trait can only be
  * mixed into a class that also extends IntQueue. Thus, you can mix Doubling
  * into BasicIntQueue, but not into Rational.
  */
trait Doubling extends IntQueue {
  abstract override def put(x: Int) {
    println("Doubling")
    /*
    The second funny thing is that the trait has a super call on a method
declared abstract. Such calls are illegal for normal classes, because they
will certainly fail at run time. For a trait, however, such a call can actually
succeed. Since super calls in a trait are dynamically bound, the super call
in trait Doubling will work so long as the trait is mixed in after another trait
or class that gives a concrete definition to the method.
     */
    super.put(2 * x)
  }
}