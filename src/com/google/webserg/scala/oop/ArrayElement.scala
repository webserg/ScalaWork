package com.google.webserg.scala.oop

/**
 * Created by sergiy.doroshenko
 * Date: 5/12/11
 * /
 *
 * class WontCompile {
private var f = 0 // Won’t compile, because a field
def f = 1 // and method have the same name
}
 */

class ArrayElement(conts: Array[String]) extends Element {
  //in Scala, fields and methods belong to the same namespace.
  // it possible for a field to override a parameterless method.
  val contents: Array[String] = conts
}