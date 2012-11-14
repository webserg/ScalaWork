object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def factorial(x: Int): Int =
    if (x == 0) 1 else x * factorial(x - 1)       //> factorial: (x: Int)Int
  /**
   * tail recursion
   */
  def factWithTailRecurcion(x: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, x)
  }                                               //> factWithTailRecurcion: (x: Int)Int
  factorial(5)                                    //> res0: Int = 120
  factWithTailRecurcion(5)                        //> res1: Int = 120

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)              //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res2: Int = 144

  def factInProduct(n: Int) = product(x => x)(1, n)
                                                  //> factInProduct: (n: Int)Int
  factInProduct(5)                                //> res3: Int = 120

  def sumAndProduct(f: Int => Int, k: (Int, Int) => Int, x: Int)(a: Int, b: Int): Int =
    if (a > b) x
    else k(f(a), sumAndProduct(f, k, x)(a + 1, b))//> sumAndProduct: (f: Int => Int, k: (Int, Int) => Int, x: Int)(a: Int, b: Int)
                                                  //| Int

  sumAndProduct(x => x * x, (y, j) => y + y, 0)(3, 4)
                                                  //> res4: Int = 18
  def map(s: Int, f: Int => Int): Int = f(s)      //> map: (s: Int, f: Int => Int)Int
  type Set = Int => Boolean
  def map2(s: Set, f: Int => Int): Set = x=>s(f(x))
                                                  //> map2: (s: Int => Boolean, f: Int => Int)Int => Boolean
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
  val s = map2(Set(2),f => f * f)                 //> s  : Int => Boolean = <function1>
  contains(s,4)                                   //> res5: Boolean = false
  map(1, f => f + 4)                              //> res6: Int = 5
}