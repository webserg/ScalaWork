object worksheet {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(75); 
  def factorial(x: Int): Int =
    if (x == 0) 1 else x * factorial(x - 1);System.out.println("""factorial: (x: Int)Int""");$skip(188); 
  /**
   * tail recursion
   */
  def factWithTailRecurcion(x: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, x)
  };System.out.println("""factWithTailRecurcion: (x: Int)Int""");$skip(15); val res$0 = 
  factorial(5);System.out.println("""res0: Int = """ + $show(res$0));$skip(27); val res$1 = 
  factWithTailRecurcion(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(108); 

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$2 = 
  product(x => x * x)(3, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(54); 

  def factInProduct(n: Int) = product(x => x)(1, n);System.out.println("""factInProduct: (n: Int)Int""");$skip(19); val res$3 = 
  factInProduct(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(158); 

  def sumAndProduct(f: Int => Int, k: (Int, Int) => Int, x: Int)(a: Int, b: Int): Int =
    if (a > b) x
    else k(f(a), sumAndProduct(f, k, x)(a + 1, b));System.out.println("""sumAndProduct: (f: Int => Int, k: (Int, Int) => Int, x: Int)(a: Int, b: Int)Int""");$skip(56); val res$4 = 

  sumAndProduct(x => x * x, (y, j) => y + y, 0)(3, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(45); 
  def map(s: Int, f: Int => Int): Int = f(s)
  type Set = Int => Boolean;System.out.println("""map: (s: Int, f: Int => Int)Int""");$skip(80); 
  def map2(s: Set, f: Int => Int): Set = x=>s(f(x));System.out.println("""map2: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(53); 
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(34); 
  val s = map2(Set(2),f => f * f);System.out.println("""s  : Int => Boolean = """ + $show(s ));$skip(16); val res$5 = 
  contains(s,4);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(21); val res$6 = 
  map(1, f => f + 4);System.out.println("""res6: Int = """ + $show(res$6))}
}