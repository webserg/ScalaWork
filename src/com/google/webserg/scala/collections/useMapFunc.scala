package com.google.webserg.scala.collections

//the subtract(x, y) is List(('a', 1), ('d', 1), ('l', 1)).
object useMapFunc extends App {
  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
  val y = List(('r', 1))

  val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("python", 10))
  val votesByLang = votes groupBy { case (lang, _) => lang }
  println(votesByLang)
  val sumByLang = votesByLang map {
    case (lang, counts) => val countsOnly = counts map { case (_, count) => count }
      println(countsOnly)
      (lang, countsOnly.sum)
  }
  println(sumByLang)
  val orderedVotes = sumByLang.toSeq
    .sortBy { case (_, count) => count }
    .reverse

  println(orderedVotes)

}