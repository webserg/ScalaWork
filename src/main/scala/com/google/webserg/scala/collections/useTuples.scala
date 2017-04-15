package com.google.webserg.scala.collections

/**
  * One use of tuples is for functions that return more than one value.
  */
object useTuples extends App {
  val pair = (99, "luf")
  println(pair._1)
  println(pair._2)
  val t = (1, 3.14, "Fred")
  println(t)

  //For example, the
  //partition method of the StringOps class returns a pair of strings, containing the
  //characters that fulfill a condition and those that don't:
  val res = "New York".partition(_.isUpper) // yields the pair ("NY", "ew ork")
  println(res)

  case class Posting(postingId: Int)

  val l: List[(Int, Iterable[(Posting, Posting)])] = List((1, Seq((Posting(1), Posting(2)), (Posting(1), Posting(3)))))

  val res2 = l.flatMap(_._2).groupBy(_._1).mapValues(v => v.map(i => i._2))

  println(res2)

}