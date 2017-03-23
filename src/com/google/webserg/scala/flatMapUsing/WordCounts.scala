package com.google.webserg.scala.flatMapUsing

/**
  * Created by webse on 3/19/2017.
  */
object WordCounts extends App {
  var res = List("1 2 3 4 5 6", "7 8 9 10", "2 4 7 8 3 2")
    .flatMap(s => s.split(" "))
    .map(w => (w, 1))
    .groupBy { case (w, _) => w }
    .map { case (w, count) => (w, count.size) }.toSeq
    .sortBy { case (w, _) => Integer.valueOf(w) }

  println(res)

  val list = Seq(("one", "i"), ("two", "2"), ("two", "ii"), ("one", "1"), ("four", "iv"))
  println(list.groupBy(_._1))
  val res2 = list.groupBy(_._1).mapValues(_.map(_._2))
  println(res2)
}
