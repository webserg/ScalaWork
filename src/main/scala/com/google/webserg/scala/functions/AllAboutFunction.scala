package com.google.webserg.scala.functions

object AllAboutFunction extends App {

  //In Scala, functions are instances of classes. You can do anything to a function that you
  //would do to an instance. We can create a function and assign it to a variable:

  val f: Int => String = x => "Dude: " + x

  println(f.toString) //We can call a method on the function:

  f == f //We can compare the function:

  def w42(f: Int => String) = println(f(42)) //Functions are passed to methods and other functions just as with any other parameter.

  def fm(i: Int) = "fm " + i

  w42((i: Int) => fm(i)) // We can create a function to pass to w42 by declaring the parameter i and its type, Int, and call fm with i:

  w42(i => fm(i)) // But the Scala type inferencer can figure out that we?re passing Int => String, so there's no reason to declare is type:

  w42(fm _) //We can further shorten things by passing fm and partially applying it. Partial application happens when we supply some but not all of the parameters required for the method or function.

  w42(fm) // we can just pass fm as if it were a variable, and the Scala compiler figures it out

  //You can pass functions that are multiline blocks of code. In this case, we?re creating
  //a range and then converting the range to a comma-separated String with Seq?s mkString
  //method.
  w42 {
    i =>
      val range = 1 to i
      range.mkString(",")
  }

  /*
   * Methods and functions are different things. In Scala, everything except a method is an
instance; therefore methods are not instances. Methods are attached to instances and can
be invoked on instances. Functions are instances that implement a FunctionNN trait, where
NN is the number of parameters the function takes. Theres nothing magic at runtime
about functions. However, at compile time, there is plenty of syntactic sugar that makes
the number of characters required to create a function very, very small.
   */

  def plus(a: Int, b: Int) = "Result is: " + (a + b)

  /*
   *a function that takes two Ints and returns a String is the same as a function that
takes an Int and returns a function that takes an Int and returns a String. Thus (Int, Int)
=> String and Int => Int => String are the same in Haskell but not in Scala. Haskell makes
it easy to create a new function by applying the first parameter to a function that will return
a new function that can then be passed around or applied. This is called partial application
because some of the parameters are passed to the function rather than all the parameters
being applied to the function. Scala requires a separate syntax to automatically generate
partially applied functions. 
   */
  val p = (b: Int) => plus(42, b) // we?ve turned a method that takes two Int parameters into a function

  //that supplies the first parameter, in this case 42, but that needs a second Int parameter
  //to fulfill the requirements for the application of plus. In this case, p is a partial application of
  //plus, and we can complete the application by supplying an Int to p.
  println(p)
  println(p(1))

  //It turns out that partial application of functions is a common thing. It allows you to
  //build up functions based on values in a given scope and allows for better code reuse. Scala
  //provides syntax to make it easier to build partially applied functions. Parameters can be
  //specified in different parenthesis groups:

  def add(a: Int)(b: Int) = "Result of add is: " + (a + b)

  println(add(1)(2))

  //With this syntax, you can pass code
  //blocks as parameters separately from other parameters.
  val res = add(1) {
    val r = new java.util.Random
    r.nextInt(100)
  }

  println(res)

  val res2 = add(1) {
    2 + 2
  }

  println(res2)

  println(w42(add(1))) //partially applied functions.
  /*
  Note that the function _.equalsIgnoreCase(_) is passed as a curried parameter, in a separate set of (...).
  When you look into the Scaladoc, you will see that corresponds is declared as
  def corresponds [B] (that: Seq[B])(p: (A, B) => Boolean) : Boolean
  The that sequence and the predicate function are separate curried parameters. The type inferencer can figure
  out what B is from the type of that, and then it can use that information when analyzing the function that is
  passed for p.
  */
  //carrien
  if (Array("Hello", "World").corresponds(Array("hello", "world"))(_.equalsIgnoreCase(_)))
    println("true")
  else println("false")


}