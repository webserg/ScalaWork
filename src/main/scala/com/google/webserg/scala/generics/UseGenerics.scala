package com.google.webserg.scala.generics

object UseGenerics extends App {

  val s = new EmptySet[Num].incl(Num(1.0)).incl(Num(2.0))

  println(s.contains(Num(1.5)))

}