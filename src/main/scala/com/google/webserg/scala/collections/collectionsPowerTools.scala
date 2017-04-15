package com.google.webserg.scala.collections

/**
  * Filter
  * Create a new collection, keeping only the elements for which a filter method returns
  * true. The size of the new collection will be less than or equal to the size of the
  * original collection.
  * Map
  * Create a new collection where each element from the original collection is transformed
  * into a new value. Both the original collection and the new collection will
  * have the same size. (Not to be confused with the Map data structure.)
  * Fold
  * Starting with a “seed” value, traverse through the collection and use each element
  * to build up a new final value where each element from the original collection “contributes”
  * to the final value. An example is summing a list of integers.
  *
  * programming scala FP 59 (Scala for Comprehensions)
  */
object collectionsPowerTools extends App {

  //It’s also possible to omit the dot (period) when calling a parameterless method or one
  //that takes only one argument	

  def isEven(n: Int) = (n % 2) == 0

  List(1, 2, 3, 4) filter isEven foreach println

  //Filtering
  val stateCapitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    "Wyoming" -> "Cheyenne")
  val map2 = stateCapitals filter { kv => kv._1 startsWith "A" }
  println(map2)

  //We’ve encountered the map method before. It returns a new collection of the same size
  //transformeds the original collection. It is also a member of Iterable, and its signature is:
  //This script produces the output ArrayBuffer((Alabama,10), (Alaska,6), (Wyoming,
  //8)). That is, we convert the Pair[String,String] elements to an ArrayBuffer of
  //Pair[String,Int] elements. Where did the ArrayBuffer come from? It turns out that
  //Iterable.map creates and returns an ArrayBuffer as the new Iterable collection.
  val lengths = stateCapitals map { kv => (kv._1, kv._2.length) }
  println(lengths)

  val l1 = List(1, 2, 3, 4, 5) map {
    _ * 2
  }
  println(l1)

  val listmap = List(1, 2, 3, 4, 5).map({
    _ * 2
  })
  println("listmap:" + listmap)

  val mapmap = stateCapitals map { kv => (kv._1, kv._2.length) }

  println("mapmap:" + mapmap)
  //==============================================================
  val foo = 1 to 5 toList
  val foo2 = foo map {
    _ + 1
  }
  println("foo2 " + foo2)

  /*
	Folding starts with an initial “seed” value and processes each element in the context of
	that value. In contrast, reducing doesn’t start with a user-supplied initial value. Rather,
	it uses the first element as the initial value:
	*/

  val l2 = List(1, 2, 3, 4, 5, 6) reduceLeft (_ + _) //reduces the list of integers by adding them together, returning 21
  println(l2)
  val l3 = List(1, 2, 3, 4, 5, 6).foldLeft(10)(_ + _) //folds the same list using multiplication with a seed of 10, returning 7,200.
  println(l3)

  //It returns List(<1>, <2>, <3>, <4>, <5>, <6>). Note that we had to call reverse on
  //the result to get back a list in the same order as the input list.
  val l4 = List(1, 2, 3, 4, 5, 6).foldLeft(List[String]()) {
    (list, x) => ("<" + x + ">") :: list
  }.reverse
  println(l4)
  println(1 to 10 filter (_ != 4))

  def removeDublicates(l: List[Int]): List[Int] = l match {
    case Nil => l
    case head :: tail => {
      println(l)
      println("head= " + head + " tail=" + tail)
      head :: removeDublicates(tail filter (_ != head))
    }
  }

  val l5 = List(4, 1, 2, 3, 4, 4, 4, 4, 88, 3, 0, 5, 6)
  println(removeDublicates(List(1, 2, 3, 4, 4)))

  def removeDuplicates2[A](xs: List[A]): List[A] =
    if (xs.isEmpty) xs
    else {
      println(xs);
      xs.head :: removeDuplicates2(xs.tail filter (x => x != xs.head))
    }

  def removeDuplicates3[A](xs: List[A]): List[A] =
    if (xs.isEmpty) xs
    else xs.head :: removeDuplicates3(for (x <- xs.tail if x != xs.head) yield x)

  println(removeDuplicates2(l5))
  println(removeDuplicates3(l5))
}
