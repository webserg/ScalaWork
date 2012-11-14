object streams {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)
  val n4m = (nats map (_ * 4))                    //> n4m  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
 	n4m.take(10).toList                       //> res0: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36)
 def sieve(s:Stream[Int]):Stream[Int] =
 s.head #:: sieve(s.tail filter (_ % s.head !=0)) //> sieve: (s: Stream[Int])Stream[Int]
  
}