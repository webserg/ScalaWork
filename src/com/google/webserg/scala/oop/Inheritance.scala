package com.google.webserg.scala.oop

class Base(name: String) {
  override def toString = "[base:" + name + "]"
}

class ChildA(name: String, age: Int) extends Base(name: String) {
  override def toString = "[ChildA :" + super.toString + "age=" + age + "]"
}

object Inheritance extends App {
  val childA: ChildA = new ChildA("serg", 31)
  println(childA)
}