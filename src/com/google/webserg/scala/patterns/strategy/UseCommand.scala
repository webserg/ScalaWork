package com.google.webserg.scala.patterns.strategy

/**
  * Created by webserg on 22.02.14.
  * In object-oriented programming, the command pattern is a behavioral design pattern in which an object is
  * used to represent and encapsulate all the information needed to call a method at a later time.
  * This information includes the method name, the object that owns the method and values for the method parameters.
  * *
  * Four terms always associated with the command pattern are command, receiver, invoker and client.
  * A command object has a receiver object and invokes a method of the receiver in a way that is specific to that receiver's class.
  * The receiver then does the work. A command object is separately passed to an invoker object, which invokes the command,
  * and optionally does bookkeeping about the command execution. Any command object can be passed to the same invoker object.
  * Both an invoker object and several command objects are held by a client object. The client contains the decision making
  * about which commands to execute at which points. To execute a command, it passes the command object to the invoker object.
  */
object UseCommand extends App {

  object Invoker {
    private var history: Seq[() => Unit] = Seq.empty

    def invoke(command: => Unit) {
      // by-name parameter
      command
      history :+= command _
    }

    def printAllHistory() = history.foreach(c => println(c))
  }

  Invoker.invoke(println("foo"))

  Invoker.invoke {
    println("bar 1")
    println("bar 2")
  }

  Invoker.printAllHistory

}
