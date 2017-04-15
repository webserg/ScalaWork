package com.google.webserg.scala.oop

import scala.Array._

/**
  * Created by sergiy.doroshenko
  * Date: 5/17/11
  */

class LineElement(s: String) extends Element {
  val contents = Array(s)

  override def width = s.length

  override def height = 1
}