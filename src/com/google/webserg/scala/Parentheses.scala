package com.google.webserg.scala

object Parentheses {

  def main(args: Array[String]): Unit = {
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
    println(balance(":-)".toList))
    println(balance("())(".toList))
  }

  def balance(chars: List[Char]): Boolean = {
    def parentheses(chars: List[Char], lr: Int): Int = {
    def check(char: Char): Int = {
      if ('(' == char) 1
      else if (')' == char) -1
      else 0

    }
    if (chars.isEmpty) lr
    else if (lr >= 0) {
      parentheses(chars.tail, lr + check(chars.head))
    } else {
      lr
    }

  }
    if (chars.isEmpty) false
    if (parentheses(chars, 0) == 0) true
    else false
  }

  

}