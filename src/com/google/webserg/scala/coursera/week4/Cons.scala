package com.google.webserg.scala.coursera.week4

trait List[T]{
  def isEmpty:Boolean
  def head:T
  def tail:List[T]
} 

class Cons[T](val head:T,val tail:List[T]) extends List[T] {
	def isEmpty = false
}

class Nil[T] extends List[T]{
  def isEmpty = true
  def head:Nothing = throw new NoSuchElementException("Nil:head")
  def tail:Nothing = throw new NoSuchElementException("Nil:tail")
}

object ConsMain extends App{
  def singelton[T](elem: T)  = new Cons[T](elem,new Nil[T])
  def nth[T](n:Int,xs:List[T]):T = {
    def nth0[T](n:Int,xs:List[T],count:Int):T = {
      if(xs.isEmpty) throw new IndexOutOfBoundsException("count=" + count)
      else if(n==count) xs.head
      else nth0(n,xs.tail,count+1)
    }
    nth0(n,xs,0)
  }
  /*define n-th eement in the List, can't use arithmetic*/
  def nth1[T](n:Int,xs:List[T]):T = {
     if(xs.isEmpty) throw new IndexOutOfBoundsException("n=" + n)
     else if(n == 0) xs.head
     else nth1(n-1,xs.tail)
  }
  val s1 = singelton[Int](1)
  val s2 = singelton[Boolean](true)
  val s5 = new Cons(1,new Cons(2,new Cons(3,new Cons(4,new Nil))))
  
  //val s4 = new Cons(1,s3)
  //val s5 = new Cons(2,s4)
  val s6 = List(1,2)
  assert(3 == nth1(2,s5))
  assert(3 == nth(2,s5))
  assert(1 == nth1(0,s5))
  assert(1 == nth(0,s5))
  assert(2 == nth(1,s6))
  //println(nth(0,s5))
  println(nth1(0,s5))
  println(nth1(1,s5))
  println(nth1(2,s5))
  println(nth1(3,s5))
  println(nth(2,s5))
 // println(nth(4,s5))
}

object List{
  //List(1,2)
  def apply[T](x:T,y:T) = new Cons[T](x,new Cons(y,new Nil))
  def apply[T](x:T) = new Cons(x,new Nil)
  def apply[T]() = new Nil[T]
}
