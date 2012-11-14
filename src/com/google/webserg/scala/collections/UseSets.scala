package com.google.webserg.scala.collections

/**
 * User: Sergiy Doroshenko
 * Date: Nov 15, 2010 1:14:10 PM
 */

object UseSets {
  def main(args : Array[String]){
    //before use sets you need to choose between mutable and immutable
    //immutable predef collection.immutable.Set
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Cessna"))
    //Both mutable and immutable sets offer a + method, but their behavior
    //differs. Whereas a mutable set will add the element to itself, an immutable
    //set will create and return a new set with the element added

    jetSet = jetSet + "Lear"

    println(jetSet)
  }
}