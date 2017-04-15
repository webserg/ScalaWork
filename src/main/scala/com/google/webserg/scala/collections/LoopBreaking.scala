package com.google.webserg.scala.collections

object LoopBreaking extends App {
  var sum = 0
  for (i <- 0 to 1000) sum += i
  println(sum)
  //you want to stop when (sum > 1000).
  //What to do? There are several options.
  //(1a) Use some construct that includes a conditional that you test.
  var sum2 = 0
  (0 to 1000).toStream.takeWhile(_ => sum2 < 1000).foreach(i => sum2 += i)
  println(sum2)
  //---------------------------------------------------------------
  val sum3 = (0 to 1000).toStream.foldLeft(0)(_ + _)
  println(sum3)
  //------------------------------------------------------------
  //if the iterable is of length 0, then it throws an exception
  //if the iterable is of length 1, then it returns the single element
  //if the iterable is of length 2+ then it stores
  //the first element in a buffer, then repeatedly performs the
  // binary operation on the buffer and an iterable element, storing the results in the buffer.
  println((0 to 1000).reduceLeft(_ + _))
  //------------------------------------------------------------
  import scala.util.control.Breaks._

  var sum4 = 0
  breakable {
    for (i <- 0 to 1000) {
      sum4 += i
      if (sum4 >= 1000) break
    }
  }
  //-------------------------------------------------------------
  var sum5 = 0
  for (i <- 0 to 1000; if sum5 < 1000) sum5 += i
  println(sum5)

}