object streams {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  def from(n: Int): Stream[Int] = n #:: from(n + 1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(21); 
  val nats = from(0);System.out.println("""nats  : Stream[Int] = """ + $show(nats ));$skip(31); 
  val n4m = (nats map (_ * 4));System.out.println("""n4m  : scala.collection.immutable.Stream[Int] = """ + $show(n4m ));$skip(22); val res$0 = 
 	n4m.take(10).toList;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(90); 
 def sieve(s:Stream[Int]):Stream[Int] =
 s.head #:: sieve(s.tail filter (_ % s.head !=0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""")}
  
}