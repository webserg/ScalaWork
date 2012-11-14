package com.google.webserg.scala.useTrait.multiInheritnce

/**
 * Bluegarden
 * User: sedo
 * Date: 2/24/11
 *

 */

object UseMyQueue {
  def main(args: Array[String]) {
   // val q = new MyQueue
    val q = (new BasicIntQueue with Doubling with Incrementing with Filtering)
    q.put(2)
    q.put(4)
    println(q.get())
  }
}