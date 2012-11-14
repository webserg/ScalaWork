package com.google.webserg.scala.useTrait.multiInheritnce

import collection.mutable.ArrayBuffer

/**
 * Bluegarden
 * User: sedo
 * Date: 2/24/11
 * 
 
 */

class BasicIntQueue extends IntQueue{
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) {
      println("BasicIntQueue")
      buf += x
    }
}