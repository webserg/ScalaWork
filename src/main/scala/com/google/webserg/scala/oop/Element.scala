package com.google.webserg.scala.oop

/**
  * Created by sergiy.doroshenko
  * Date: 5/12/11
  */
/*
we could have
chosen to implement width and height as fields instead of methods, simply
by changing the def in each definition to a val:
*/
abstract class Element {
  def contents: Array[String]

  //parameterless methods
  def height = contents.length

  def width =
    if (height == 0) 0 else contents(0).length

  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element =
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString = contents mkString "\n"
}