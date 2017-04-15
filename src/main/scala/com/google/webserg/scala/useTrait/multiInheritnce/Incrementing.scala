package com.google.webserg.scala.useTrait.multiInheritnce

/**
  * Bluegarden
  * User: sedo
  * Date: 2/24/11
  *
  *
  */

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {
    println("Incrementing")
    super.put(x + 1)
  }
}