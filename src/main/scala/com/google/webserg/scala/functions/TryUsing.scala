package com.google.webserg.scala.functions

/**
  * Created by webserg on 21.01.14.
  * An important property of Try shown in the above example is its ability to pipeline, or chain,
  * operations, catching exceptions along the way. The flatMap and map combinators in the above example each essentially
  * pass off either their successfully completed value, wrapped in the Success type for it to be further operated upon by
  * the next combinator in the chain, or the exception wrapped in the Failure type usually to be simply passed on down
  * the chain. Combinators such as rescue and recover are designed to provide some type of default behavior in the case
  * of failure.
  * Note: only non-fatal exceptions are caught by the combinators on Try (see scala.util.control.NonFatal). Serious system
  * errors, on the other hand, will be thrown.
  * *
  * Note:: all Try combinators will catch exceptions and return failure unless otherwise specified in the documentation.
  * *
  * Try comes to the Scala standard library after years of use as an integral part of Twitter's stack.
  */
object TryUsing extends App {

  import scala.util.{Try, Success, Failure}

  def divide: Try[Int] = {
    val dividend = Try(Console.readLine("Enter an Int that you'd like to divide:\n").toInt)
    val divisor = Try(Console.readLine("Enter an Int that you'd like to divide by:\n").toInt)
    val problem = dividend.flatMap(x => divisor.map(y => x / y))
    problem match {
      case Success(v) =>
        println("Result of " + dividend.get + "/" + divisor.get + " is: " + v)
        Success(v)
      case Failure(e) =>
        println("You must've divided by zero or entered something that's not an Int. Try again!")
        println("Info from the exception: " + e.getMessage)
        divide
    }
  }

  divide

}
