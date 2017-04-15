package com.google.webserg.scala.collections

/**
  * sorting
  */
case class Thing(number: Int, name: String) extends Ordered[Thing] {
  def compare(that: Thing) = name.compare(that.name)
}

object Sorting extends App {
  val array = Array(Thing(4, "Doll"), Thing(2, "Monkey"), Thing(7, "Green"))
  scala.util.Sorting.quickSort(array)
  array.foreach { e => print(e) };
  println
  //>> Thing(4,Doll) Thing(7,Green) Thing(2,Monkey)
  //=====================================================================
  type Pair = (String, Int)
  val items: Array[Pair] = Array(("one", 1), ("three", 3), ("two", 2))
  scala.util.Sorting.quickSort(items)(new Ordering[Pair] {
    def compare(x: Pair, y: Pair) = {
      x._2 compare y._2
    }
  })
  items.foreach { e => print(e) };
  println

}