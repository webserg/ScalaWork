package com.google.webserg.scala.coursera.week7
object test {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
  val problem = new Pouring(Vector(4,9,19));System.out.println("""problem  : com.google.webserg.scala.coursera.week7.Pouring = """ + $show(problem ));$skip(16); val res$0 = 
  problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with com.google.webserg.scala.coursera.week7.test.problem.Move] = """ + $show(res$0));$skip(62); val res$1 = 
 //problem.pathSets.take(6).toList
  
  problem.solutions(17);System.out.println("""res1: Stream[com.google.webserg.scala.coursera.week7.test.problem.Path] = """ + $show(res$1))}
}