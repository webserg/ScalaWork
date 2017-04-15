package com.google.webserg.scala.oop

object PersonObject extends App {
  val p = new Person("serg", "doroshenko", 12345)
  p.age_=(22)
  p.age = 24
  println(p.age)

  println(p)

  val p2 = new Person("serg", "doroshenko", 56789, "M")
  println(p2)
  //
  //	if (p.isInstanceOf[Student]) {
  //val s = p.asInstanceOf[Student] // s has type Student
  //}
}