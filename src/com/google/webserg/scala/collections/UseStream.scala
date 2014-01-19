package com.google.webserg.scala.collections

object UseStream extends App{
  def from(n:Int):Stream[Int] = n #::from(n+1)
  val nats = from(0)
  nats map (_ * 4)
  val fibs:Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ t => t._1 + t._2 }
  fibs take 10 toList

}