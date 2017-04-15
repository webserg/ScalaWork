package com.google.webserg.scala.coursera.week7

object test {
  val problem = new Pouring(Vector(4, 9, 19)) //> problem  : com.google.webserg.scala.coursera.week7.Pouring = com.google.webs
  //| erg.scala.coursera.week7.Pouring@6fc6e58
  problem.moves //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with c
  //| om.google.webserg.scala.coursera.week7.test.problem.Move] = Vector(Empty(0),
  //|  Empty(1), Empty(2), Fill(0), Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1
  //| ,0), Pour(1,2), Pour(2,0), Pour(2,1))
  //problem.pathSets.take(6).toList

  problem.solutions(17)
}