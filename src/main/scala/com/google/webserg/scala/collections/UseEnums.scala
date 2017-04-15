package com.google.webserg.scala
package collections

import TrafficLightColor._

object UseEnums extends App {
  val color = Red // don't use type TrafficLightColor!!!!! use TrafficLightColor.value
  if (color == Red) println("stop ")
  else if (color == Yellow) println("hurry up")
  else if (color == Green) println("go")
  println(" -- ")
  //println(doWhat(TrafficLightColor.Red))

  for (c <- TrafficLightColor.values) println(c.id + ": " + c)

  println(TrafficLightColor(0)) // Calls Enumeration.apply
  println(TrafficLightColor.withName("Stop")) //	yield the object TrafficLightColor.Red.

}