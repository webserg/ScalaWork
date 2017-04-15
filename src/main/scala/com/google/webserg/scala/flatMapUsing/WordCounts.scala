package com.google.webserg.scala.flatMapUsing

import java.util

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

  val langs = List("1", "2", "3")
  val wikis = List("21 123123 3453453 34534", "8787879696", "9695 687595", "22222", "33333", "222233 333333")

  val invertedIndex = wikis.flatMap(w => {
    val langsinWki = langs.filter(lang => w.contains(lang))
    langsinWki.map(lang => (lang, w))
  })
  println(invertedIndex.groupBy(_._1))


  def flatMap[U, T](list: List[T], f: T => List[U]): List[U] = list match {
    case head :: tail => f(head) ++ flatMap(tail, f)
    case Nil => Nil
  }

  var resList = List("1 2 3 4 5 6", "7 8 9 10", "2 4 7 8 3 2")
    .flatMap(s => s.split(" "))

  var resList2 = flatMap[String,String](List("1 2 3 4 5 6", "7 8 9 10", "2 4 7 8 3 2"), s => s.split(" ").map(_.trim).toList)
  println(resList2)
  assert(resList==resList2)

  println(List("1 2 3 4 5 6", "7 8 9 10", "2 4 7 8 3 2").flatMap(s=>s))
  println(List("1 2 3 4 5 6", "7 8 9 10", "2 4 7 8 3 2").flatten)


}
