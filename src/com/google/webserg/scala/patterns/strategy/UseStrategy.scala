package com.google.webserg.scala.patterns.strategy


/**
 * Created by webserg on 22.02.14.
 * the strategy pattern (also known as the policy pattern) is a software design pattern,
 * whereby an algorithm's behaviour can be selected at runtime. Formally speaking,
 * the strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.[1]
 * Strategy is one of the patterns included in the influential book "Design Patterns" by Gamma et al.
 * that popularized the concept of using patterns in software design.
 */
object UseStrategy extends App {

  type Strategy = (Int, Int) => Int

  class Context(computer: Strategy) {
    def use(a: Int, b: Int)= {
      computer(a, b)
    }
  }

  val add: Strategy = _ + _
  val multiply: Strategy = _ * _

  val res = new Context(multiply).use(2, 3)

  println(res)
}
