/**
 * Created by sergiy.doroshenko
 * Date: 4/30/11
 */
package com.google.webserg.scala
object QuikeSort {

  def quickSort(values: Array[Int]) : Array[Int] = {

    def swap(i1: Int, i2: Int) {
      val tmp = values(i1)
      values(i1) = values(i2)
      values(i2) = tmp
    }

    def sort(f: Int, l: Int) {
      if (f >= l) ();
      val splitVal = values((f + l) / 2)
      var i = f;
      var j = l
      while (i <= j) {
        while (values(i) < splitVal) i += 1
        while (values(j) > splitVal) j -= 1
        if (i <= j) {
          swap(i, j);
          i += 1;
          j -= 1
        }
        values.foreach(print(_));println()
      }
      if (f < j) sort(f, j)
      if (j < l) sort(i, l)
    }
    sort(0, values.length - 1)
    values
  }

  //java style
  def quickSort2(xs: Array[Int]): Array[Int]= {
    def swap(i: Int, j: Int) {
      val t = xs(i);
      xs(i) = xs(j);
      xs(j) = t
    }
    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)
      var i = l;
      var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
        xs.foreach(print(_));println()
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }
    sort1(0, xs.length - 1);xs
  }

  //scala style

  /*
  • If the array is empty or consists of a single element, it is already sorted, so
   return it immediately.
  • If the array is not empty, pick an an element in the middle of it as a pivot.
  • Partition the array into two sub-arrays containing elements that are less than,
    respectively greater than the pivot element, and a third array which contains
    elements equal to pivot.
  • Sort the first two sub-arrays by a recursive invocation of the sort function.1
  • The result is obtained by appending the three sub-arrays together.
  */
  def quickSortScala(xs: Array[Int]): Array[Int] = {
    xs.foreach(print(_));println()
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      println("pivot = " + pivot)
      Array.concat(
        quickSortScala(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSortScala(xs filter (pivot <)))
    }
  }

  def main(args: Array[String]) {

    val arr = scala.util.Random.shuffle(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).toArray
    arr.foreach(print(_));
    println()
    quickSort(arr)
    println("=====================")
    val arr2 = scala.util.Random.shuffle(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).toArray
    quickSort(arr2)
    println("=====================")
    val arr3 = scala.util.Random.shuffle(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).toArray
    quickSortScala(arr3).foreach(print(_));println();
    println("=====================")
  }

}