package com.google.webserg.scala.oop

/**
  * Created by webserg on 04.02.14.
  */
class Person2(var firstName: String, var lastName: String) {
  println("the constructor begins")
  // some class fields
  private val HOME = System.getProperty("user.home")
  var age = 0

  // some methods
  override def toString = s"$firstName $lastName is $age years old"

  def printHome {
    println(s"HOME = $HOME")
  }

  def printFullName {
    println(this)
  } // uses toString
  printHome
  printFullName
  println("still in the constructor")
}
