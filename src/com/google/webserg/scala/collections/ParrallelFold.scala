package com.google.webserg.scala.collections

/**
  * Created by webse on 3/26/2017.
  */
object ParrallelFold extends App {

  def scanLeft[A](inp: Array[A], a0: A, f: (A, A) => A, out: Array[A]): Unit = {
    out(0) = a0
    var a = a0
    var i = 0
    while (i < inp.length) {
      a = f(a, inp(i))
      i = i + 1
      out(i) = a
    }
  }

//  def reduceSeg1[A](inp: Array[A], left: Int, right: Int, a0: A, f: (A, A) => A): A = {
//
//  }
//
//  def mapSeg[A, B](inp: Array[A], left: Int, right: Int, fi: (Int, A) => B, out: Array[B]): Unit = {
//
//  }

  val list = List(1, 3, 8)

  val seqRes = list.scanLeft(100)(_ + _)

  println(seqRes)
  val emptyArray = Array(0, 0, 0, 0)
  scanLeft[Int](Array(1, 3, 8), 100, _ + _, emptyArray)
  emptyArray.map(_ + " ").foreach(print)

}
