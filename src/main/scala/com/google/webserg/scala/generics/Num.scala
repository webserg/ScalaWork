package com.google.webserg.scala.generics

case class Num(value: Double) extends Ordered[Num] {
  def compare(that: Num): Int =
    if (this.value < that.value) 1
    else if (this.value > that.value) 1
    else 0
}