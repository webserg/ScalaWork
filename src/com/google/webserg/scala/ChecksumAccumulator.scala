package com.google.webserg.scala

/**
  * User: Sergiy Doroshenko
  * Date: Nov 17, 2010 5:43:17 PM
  */

class ChecksumAccumulator {
  private var sum = 0


  //  def add(b: Byte): Unit = {
  //    sum += b
  //  }
  //you can leave off the
  //curly braces if a method computes only a single result expression.

  def add(b: Byte): Unit = sum += b

  def checksum(): Int = {
    //return ~(sum & 0xFF) + 1 //In the absence of any explicit return
    //statement, a Scala method returns the last value computed by the method
    ~(sum & 0xFF) + 1
  }
}

/**
  * The singleton object in this figure is named ChecksumAccumulator, the
  * same name as the class in the previous example. When a singleton object
  * shares the same name with a class, it is called that class companion object.
  * You must define both the class and its companion object in the same source
  *file. The class is called the companion class of the singleton object. A class
  * and its companion object can access each other’s private members.
  */
object ChecksumAccumulator {
  private var cache = Map[String, Int]()

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}