package com.google.webserg.scala.collections
import scala.xml._
/**
  * Created by webse on 4/17/2017.
  */
object Scalar extends App {
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

  val n = 20
  //find all pairs sum of which give you prime number
  //for searching prime number you should find all pairs and filter sum  like prime number
  // you can use fundamental operation map, flatMap(union map and flatten),and filter
  // but it is hard to read, so for better reading use comprehended for exprations
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))

  val res = for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)

  println(res)

  case class Person(name: String, age: Int)

  val persons = List(Person("a", 21))
  // pure functional style without mutate state
  // for consist of tree bloc (for{generator(may be several) if statement(may be several)} )
  for (p <- persons if p.age > 20) yield p.name
  //equivalent to expr
  persons filter (p => p.age > 20) map (p => p.name)

  def scalar(xs: List[Double], ys: List[Double]): Double = {
    (for ((x, y) <- xs zip ys) yield x * y) sum
  }

  def scalar2(xs: List[Double], ys: List[Double]): Double = {
    xs zip ys map (xy => xy._1 * xy._2) sum
  }

  def scalar3(xs: List[Double], ys: List[Double]): Double = {
    xs zip ys map { case (x, y) => x * y } sum
  }

  println(scalar(List(1, 1), List(2, 2)))
  println(scalar2(List(1, 1), List(2, 2)))
  println(scalar3(List(1, 1), List(2, 2)))

  // combination of all numbers 1..n * 1..M
  val N = 10
  val M = 5
  val res2 = 1 to N flatMap (x => 1 to M map (y => (x, y)))

  println(res2)

  //eratosfen filter
  val NN = 20

  val resErat = 1 to NN filter( x => x%2 != 0)
  println(resErat)
 /*
 * Фильтрация списка чисел на две категории, основанные на использовании partition.
 * В этом примере создаются два списка студентов по результатам их тестирования.
 * */
  val (passed, failed) = List(49, 58, 76, 82, 88, 90) partition ( _ > 60 )

  println(passed,failed)

//  val results = XML.load(" https://api.twitter.com/1.1/search/tweets.json?q=from%3ACmdr_Hadfield%20%23nasa&result_type=popular")
//
//  println(results)
  List(14, 35, -7, 46, 98).reduceLeft ( _ min _ )
  List(14, 35, -7, 46, 98).reduceLeft ( _ max _ )


  // sieve of eratosthenes
  def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter (_ % s.head != 0))
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
  def primes = sieve(from(NN))

  println(primes)


}
