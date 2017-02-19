package com.google.webserg.scala.collections
/**
 * remmember Array, List etc in scala are immutable!!!!
 */
object UseArray extends App {
  //If you need an array whose size doesn't change, use the Array type in Scala
  val a = new Array[String](10)// A string array with ten elements, all initialized with null
  val s = Array("Hello", "World")// An Array[String] of size type is inferred Note: No new when you supply initial values
  s(0) = "GoodBay"
  s.foreach(println)
    
    //java ArrayList equivalent is ArrayBuffer
   import scala.collection.mutable.ArrayBuffer 
   val b = new ArrayBuffer[Int]()
   b+=1
   b+=(1,2,3,4,5)
   
   b ++= Array(1,2,3,4,5,6) // append any collection
   
   for(i <- b)
     print(i)
   println  
   for(i <- 0 until (b.size,2))
    print(i)
   println 
    for(i <- (0 until (b.size,2)).reverse)
    print(i)
   println
 //These transformations don't modify the original array, but they yield a new one.
   val result = for (elem <- b) yield 2 * elem
   for(i <- result)
     print(i)
  println
   val result2 = for (elem <- b if (elem % 2 == 0)) yield 2 * elem
   for(i <- result2)
     print(i)
   println(" it was even")

   val result3 = b.filter(_ % 2 == 0).map(2 * _)
   for(i <- result3)
     print(i)
    println

    //Given a sequence of integers, we want to remove all but the first negative number.
    val v = ArrayBuffer(1, 7, -2, 9, -1, 3, 5, 7, 3, 2)
    val indexes = for (i <- 0 until v.size if v(i) < 0) yield i
    for(j <- (0 until indexes.size).reverse) v.remove(indexes(j))
    for(i <- v) print(i);println
    
    //common algorithm
    println( Array(1, 7, 2, 9).sum )
    println( ArrayBuffer("Mary", "had", "a", "little", "lamb").max )//little
    val unsorted1 = ArrayBuffer(1, 7, 2, 9)
    val bSorted = unsorted1.sortWith(_ < _)// unsorted1 is unchanged; bSorted is ArrayBuffer(1, 2, 7, 9)
    for(i <- bSorted) print(i);println

    val aSort = Array(1, 7, 2, 9)
    scala.util.Sorting.quickSort(aSort) // a is now Array(1, 2, 7, 9)
    for(i <- aSort) print(i);println
}