package com.google.webserg.scala.functions

/**
  * @author Sergiy Doroshenko
  *         email:webserg@gmail.com
  *         Date: 3/26/11 11:59 PM
  *
  *         One of the main characteristics of a functional language is that functions
  *         are first class constructs, and that�s very true in Scala. For example, another
  *         (far more concise) way to print each command line argument is:
  *args.foreach(arg => println(arg))
  *         In this code, you call the foreach method on args, and pass in a function. In
  *         this case, youre passing in a function literal that takes one parameter named
  *arg. The body of the function is println(arg). If
  */

object FunctionLiterals extends App {
  var increase = (x: Int) => x + 1
  println(increase(10))
  increase = (x: Int) => x + 9999
  println(increase(10))
  //if you need more then one statment
  increase = (x: Int) => {
    println("We")
    println("are")
    println("here!")
    x + 1
  }
  println(increase(10))
}