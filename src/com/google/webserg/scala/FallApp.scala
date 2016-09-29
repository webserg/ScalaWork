package com.google.webserg.scala

/**
 * User: Sergiy Doroshenko
 * Date: Nov 18, 2010 3:38:25 PM
 */

import ChecksumAccumulator.calculate
// inherit applications and you don't need write main method
object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}