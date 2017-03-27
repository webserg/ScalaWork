package com.google.webserg.scala.collections

/**
  * Created by webse on 3/25/2017.
  */
object listAvarageFunctional extends App{

  val list = List(9, 2, 3, 4, 5)
  val sum = list.reduce(_ + _)
  val len = list.map(x => 1).reduce(_ + _)
  sum / len
  val f: ((Int, Int), (Int, Int)) => (Int, Int) = {
    case ((sum1, len1), (sum2, len2)) => (sum1 + sum2, len1 + len2)
  }

  val listPair = list.map(x => (x, 1))
  val res= listPair.reduce(f)

  println(res)
  val (sumRes,lenRes) = res
  println(sumRes/lenRes)

}
