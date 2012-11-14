package com.google.webserg.scala.functions
/**
 * Methods can be declared within any code scope, except at the top level, where classes,
traits, and objects are declared. Methods can reference any variables in their scope:
 */
object FunctionsSyntacs extends App{

  def list[T](p: T): List[T] = p :: Nil // code takes a parameter p and a type parameter T and returns a List of T.
  println(list("hello")) // res3: List[java.lang.String] = List(Hello)
  
  def largest(as: Int*): Int = as.reduceLeft((a, b) => a max b) // repeat argument Int*
  println(largest(1))
  println(largest(2, 3, 99))
  println(largest(44, 22, 33, 22))
  
  def mkString[T](as: T*): String = as.foldLeft("")(_ + _.toString)//You can mix type parameters with variable-length arguments:
  
  def sum[T <: Number](as: T*): Double = as.foldLeft(0d)(_ + _.doubleValue)//And you can put bounds on the type parameters. In this case, the types that are passed in must be Number or a subclass of Number:
  
}

