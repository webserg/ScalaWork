package com.google.webserg.scala.coursera.week4

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
  def == (that:Nat) : Boolean
}

object Zero extends Nat {
  def isZero = true
  def predecessor: Nat = throw new Exception()
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = {
    if(that.isZero) this
    else  throw new Exception()
  }
  def == (that:Nat) = {
    if(that.isZero) true
    else false
  }
}
//successor
class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor: Nat = n
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat = n + that.successor
  def -(that: Nat): Nat = {
    n - that.predecessor
  }
  def == (that:Nat) = {
    if(that.isZero) false
    else n == that.predecessor
  }

}

object NatMain extends App{
  val z = Zero
  val one = z.successor
  val two = one.successor
  val three = two.successor
  val four = three.successor
  val five = four.successor
  val six = five.successor
  
  assert((one-one) == Zero)  
  assert((one+two) == three)  
  assert((one+five) == six)  
  assert((six-(five+one)) == Zero)  
}