package com.google.webserg.scala.functions

/**
 * Created by webserg on 10.02.14.
 * The function value (the object) that's created at runtime from this function literal is called a closure.
 * The name arises from the act of "closing" the function literal by "capturing" the bindings of its free variables.
 * A function literal with no free variables, such as (x: Int) => x + 1, is called a closed term,
 * where a term is a bit of source code. Thus a function value created at runtime from this function literal is not a closure in the strictest sense,
 * because (x: Int) => x + 1 is already closed as written. But any function literal with free variables, such as (x: Int) => x + more, is an open term.
 * Therefore, any function value created at runtime from (x: Int) => x + more will by definition require that a binding for its free variable, more, be captured.
 * The resulting function value, which will contain a reference to the captured more variable, is called a closure, therefore,
  * because the function value is the end product of the act of closing the open term, (x: Int) => x + more.
 */
object ClosureUsing extends App{

  var more=1
  val addMore = (x: Int) => x + more
  println(addMore(10))//11)
  more =2
  println(addMore(10))//,12)

}
