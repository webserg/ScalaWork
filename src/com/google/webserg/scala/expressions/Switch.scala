package com.google.webserg.scala.expressions

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 4/3/11 9:01 PM
 */

/**
 * Instead the break
is implicit, and there is no fall through from one alternative to the next. The
common case not falling throughbecomes shorter, and a source of errors
is avoided because programmers can no longer fall through by accident.
 */
object Switch {
  def main(args: Array[String]) {
    val firstArg = if (args.length > 0) args(0) else ""
    firstArg match {
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")

    }
    //yeild to value
    val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
    println(friend)
  }
}