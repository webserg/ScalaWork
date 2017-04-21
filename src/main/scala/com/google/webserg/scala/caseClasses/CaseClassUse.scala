package com.google.webserg.scala.caseClasses


case class Person(lastname: String, firstname: String, birthYear: Int)

object CaseClassUse {

  def main(args: Array[String]): Unit = {

    val p = Person("Lacava", "Alessandro", 1976)
    val lastname = p.lastname
    // the following won't compile:
    //p.lastname = "Brown"

    val p_1 = Person("Brown", "John", 1969)
    val p_2 = Person("Lacava", "Alessandro", 1976)

    p == p_1 // false
    p == p_2 // true
    // the result is: Person(Lacava,Michele,1972), my brother :)
    val p_3 = p.copy(firstname = "Michele", birthYear = 1972)

    val Person(lname, _, _) = p

    println(lname) // prints Lacava

    val personCreator: (String, String, Int) => Person = Person.apply

    // the result is: Person(Brown,John,1969)
    personCreator("Brown", "John", 1969)

   // What if you want your function, from the previous point, to be curried? Enters the curried method:

    val curriedPerson: String => String => Int => Person = Person.curried

    val lacavaBuilder: String => Int => Person = curriedPerson("Lacava")

    val me = lacavaBuilder("Alessandro")(1976)
    val myBrother = lacavaBuilder("Michele")(1972)
    val notBrother = Person("NotLacava","Michele",1972)

    println(me)
    println(myBrother)

  }

}