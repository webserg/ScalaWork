package com.google.webserg.scala.oop

/**
  * Created by sergiy.doroshenko
  * Date: 5/17/11
  */

class UniformElement(
                      ch: Char,
                      override val width: Int,
                      override val height: Int
                    ) extends Element {
  private val line = ch.toString * width

  def contents = Array(line)
}