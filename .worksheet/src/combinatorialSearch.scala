object combinatorialSearch {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(85); val res$0 = 
  //second prime number beetwen 1000 and 10000
  ((1000 to 10000) filter isPrime)(1);System.out.println("""res0: Int = """ + $show(res$0));$skip(56); 
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty));System.out.println("""xs  : Stream.Cons[Int] = """ + $show(xs ));$skip(28); 
  val xxs = Stream(1, 2, 3);System.out.println("""xxs  : scala.collection.immutable.Stream[Int] = """ + $show(xxs ));$skip(21); val res$1 = 
  (1 to 10).toStream;System.out.println("""res1: scala.collection.immutable.Stream[Int] = """ + $show(res$1));$skip(138); 
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  };System.out.println("""streamRange: (lo: Int, hi: Int)Stream[Int]""");$skip(112); 
  def listRange(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi) Nil
    else lo :: listRange(lo + 1, hi)
  };System.out.println("""listRange: (lo: Int, hi: Int)List[Int]""");$skip(47); val res$2 = 
  ((1000 to 10000).toStream filter isPrime)(1);System.out.println("""res2: Int = """ + $show(res$2))}
}