package com.google.webserg.scala.collections

object FoldleftUse extends App {
  val l3 = List(1, 2, 3, 4).foldLeft(3)(_ + _) //folds the same list using multiplication with a seed of 10, returning 7,200.
  println(l3)

  //It returns List(<1>, <2>, <3>, <4>, <5>, <6>). Note that we had to call reverse on
  //the result to get back a list in the same order as the input list.
  val l4 = List(1, 2, 3, 4, 5, 6).foldLeft(List[String]()) {
    (list, x) => ("<" + x + ">") :: list
  }.reverse

  println(l4)
  List("How", "long", "is", "everyone?").foldLeft(0)((i, s) => i + s.length)
  //res4: Int = 18
  List("Who", "is", "longest?").foldLeft((0, ""))((i, s) =>
    if (i._1 < s.length) (s.length, s)
    else i
  )
  //res5: (Int, java.lang.String) = (8,longest?)

  println(List("How", "long", "is", "everyone?").foldLeft(0) { (i, s) => i max s.length })
  val what = "awesome"
  //println(s"string interpolation is ${what.toUpperCase}!")
  //  val num:Int = null
  val num: Int = 0
  val l: List[Int] = num :: List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(List(1, 2, 3, 4).max)
  println(l.max)
  //  println(List[Int]().max)
  val n = 3
  println(List(1, 2, 90, 4, 5, 6, 7, 8, 9).filter(v => v < n).minBy(v => math.abs(v - n)))
  println(List(1, 2, 90, 4, 5, 6, 7, 8, 9).filter(v => v > n).minBy(v => math.abs(v - n)))

}