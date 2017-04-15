package com.google.webserg.scala.oop

class Employee(val name: String, var salary: Double) {
  override def toString = name + " " + salary

  def this() {
    this("John Q. Public", 0.0)
  }
}

object Employee extends App {
  val e = new Employee
  println(e)
  val e2 = new EmployeeOld
  println(e2)
}