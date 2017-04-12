// package com.google.webserg.scala

object QuickSort2 extends App {

  def quickSortScala(xs: Array[Int], len: Int, c: Int): (Array[Int], Int) = {
    def swap(a: Array[Int], i: Int, j: Int) {
      val t = a(i)
      a(i) = a(j)
      a(j) = t
    }

    def partitioning(a: Array[Int], pdx: Int, len: Int): Int = {
      val p = a(pdx)
      var i = pdx + 1
      for (j <- pdx + 1 to len) {
        if (a(j) < p) {
          swap(a, j, i)
          i += 1
        }
      }
      if (pdx != i - 1) swap(a, pdx, i - 1)
      i - 1
    }

    println("len = " + len)
    if (len <= 0) {
      println("exit len = " + len)
      (xs, c)
    } else {
      xs.foreach(print(_));
      println()
      val part = partitioning(xs, 0, xs.length - 1)
      println("part = " + part)
      val parts = xs.splitAt(part)
      parts._1.foreach(print(_));
      println()

      val pair1 = quickSortScala(parts._1, part - 1, c + parts._1.length - 1)
      println("second Array = " + len)
      parts._2.foreach(print(_));
      println()
      val pair2 = quickSortScala(parts._2, len - part, c + parts._2.length - 1)
      (Array.concat(
        pair1._1,
        Array(xs(0)),
        pair2._1), pair1._2 + pair2._2)
    }
  }

  //    val arr3 = scala.util.Random.shuffle(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).toArray
  val arr3 = Array(3, 2, 5, 4, 1)
  val res = quickSortScala(arr3, arr3.length - 1, 0)
  (res._1).foreach(print(_));
  println();
  println("=====================" + res._2)

}