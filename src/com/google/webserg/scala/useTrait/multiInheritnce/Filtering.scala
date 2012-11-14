package com.google.webserg.scala.useTrait.multiInheritnce

/**
 * Bluegarden
 * User: sedo
 * Date: 2/24/11
 *

 */
/**
 * When you call a method on a class with mixins, the method in the
  trait furthest to the right is called first. If that method calls super, it invokes
  the method in the next trait to its left, and so on.
 */
trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    println("Filtering" + x)
    if (x >= 4) super.put(x)
  }
}