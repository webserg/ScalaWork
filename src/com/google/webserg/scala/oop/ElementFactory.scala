package com.google.webserg.scala.oop

/**
 * Created by sergiy.doroshenko
 * Date: 5/17/11
 *
 *  A factory object contains methods
that construct other objects. Clients would then use these factory methods
for object construction rather than constructing the objects directly with new.
An advantage of this approach is that object creation can be centralized and
the details of how objects are represented with classes can be hidden. This
hiding will both make your library simpler for clients to understand
 */

object ElementFactorydef {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)
}