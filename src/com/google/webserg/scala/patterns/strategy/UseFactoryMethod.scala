package com.google.webserg.scala.patterns.strategy

/**
 * Created by webserg on 23.02.14.
 *
 * The factory method pattern is an object-oriented creational design pattern to implement the concept of factories
 * and deals with the problem of creating objects (products) without specifying the exact class of object that will be created.
 * The essence of this pattern is to "Define an interface for creating an object,
 * but let the classes that implement the interface decide which class to instantiate.
 * The Factory method lets a class defer instantiation to subclasses."[1]

Creating an object often requires complex processes not appropriate to include within a composing object.
The object's creation may lead to a significant duplication of code, may require information not accessible
to the composing object, may not provide a sufficient level of abstraction, or may otherwise not be part of
the composing object's concerns. The factory method design pattern handles these problems by defining a separate
method for creating the objects, which subclasses can then override to specify the derived type of product
that will be created
 */
object UseFactoryMethod extends App{
  trait Animal
  private class Dog extends Animal
  private class Cat extends Animal

  object Animal {
    def apply(kind: String) = kind match {
      case "dog" => new Dog()
      case "cat" => new Cat()
    }
  }

  Animal("dog")

}
