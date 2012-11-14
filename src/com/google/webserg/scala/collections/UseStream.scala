package com.google.webserg.scala.collections

object UseStream extends App{
  def from(n:Int):Stream[Int] = n #::from(n+1)
  val nats = from(0)
  nats map (_ * 4)

}