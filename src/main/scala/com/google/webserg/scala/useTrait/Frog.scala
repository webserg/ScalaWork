package com.google.webserg.scala.useTrait

/**
  * Bluegarden
  * User: sedo
  * Date: 2/23/11
  *
  */

class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"
}