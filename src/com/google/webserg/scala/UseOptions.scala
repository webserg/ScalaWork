package com.google.webserg.scala

/**
  * Created by webse on 2/19/2017.
  */
object UseOptions extends App {

  case class User(
                   id: Int,
                   firstName: String,
                   lastName: String,
                   age: Int,
                   gender: Option[String])

  object UserRepository {
    private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
      2 -> User(2, "Johanna", "Doe", 30, None))

    def findById(id: Int): Option[User] = users.get(id)

    def findAll = users.values
  }

  val user1 = UserRepository.findById(1)
  if (user1.isDefined) {
    println(user1.get.firstName)
  } // will print "John"

  user1 match {
    case Some(n) => println(user1.get.firstName)
    case None => println("nothing")
  }

  def add1(x: Int): Int = x + 1

  //better have
  val x: Option[Int] = Some(1 + 1)
  val y = x map (_ + 1) getOrElse 0

  println(y)

  val ox:Option[Int] = Some(1)
  val oy = Some(2)
  val oz = Some(3)
  val ow:Option[Int] = None

  val res0 = for {x <- ox; y <- oy; z <- oz}
    yield x + y + z

  println("res0=" + res0)

  for (s <- res0) println("res0=" + s)

  val res = for {x <- ox; y <- oy; z <- oz;w <- ow}
    yield x + y + z + w

  val oz1 = None

  val res2 = for (z <- oz1)  yield z

  println(res)
  println(res2)

  val smth = Some("smth")

  for (s <- smth) {
    println(s)
  }
  val nothing = None

  for(s<-smth; n<-nothing) print(s + n)

}
