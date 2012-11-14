object forExpretion {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(12); 
  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(111); val res$0 = 
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2));System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(85); val res$1 = 
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)
  type Occurrences = List[(Char, Int)];System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(744); 
  //case class Person(name:String, age:Int)
  //val persons = List(Person("a",21))
  //for(p <- persons if(p.age > 20)) yield p.name
  //persons filter (p=>p.age > 20) map (p=> p.name)
  /*
  List(
  List(),
  List(('a', 1)),
  List(('a', 2)),
  List(('b', 1)),
  List(('a', 1), ('b', 1)),
  List(('a', 2), ('b', 1)),
  List(('b', 2)),
  List(('a', 1), ('b', 2)),
  List(('a', 2), ('b', 2))
)
  */
 // (1 until n) flatMap (i =>
 //   (1 until i))
  //val l3 = List(List(('a', 1)), List(('a', 2)), List(('b', 1)), List(('b', 2)))
 // l3 match {
   // case head :: tail => tail.foldLeft(head) { (list, x) => head.head :: list }
  //}

  val l: List[(Char, Int)] = List(('a', 1), ('a', 2),('b', 1),('b', 2));System.out.println("""l  : List[(Char, Int)] = """ + $show(l ));$skip(349); val res$2 = 

 // val llist = for ((k, v) <- l; j <- 1 to v) yield List((k, j))
  //llist flatMap (g=>llist) map (j=>(g,j))
  
 // l.foldLeft(Set(Set.empty[(Char, Int)])) { case (ps, el) => ps ++ ps.map(_ + el) }
     (l foldRight(List[Occurrences](Nil)) ) {
      case ((ch, tm), acc) =>  acc ::: (for { comb <- acc; n <- 1 to tm } yield (ch, n) :: comb)
    };System.out.println("""res2: List[forExpretion.Occurrences] = """ + $show(res$2));$skip(142); val res$3 = 
 // val lll = List(1,2,3,4,5)
  //1 :: lll
  //val k = ('a', 2)
	//k :: l
  l.foldLeft(List[(Char, Int)]()){
    (list, x) => (x) :: list
  };System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(206); 
  
    def compareArrays[A](arrs: List[Iterable[A]]) = arrs match {
    case a :: tail => {
      val set = a.foldLeft(Set[A]()) { _ + _ }
      tail.foldLeft(set) { _ -- _ }
    }

    case Nil => Nil
  };System.out.println("""compareArrays: [A](arrs: List[Iterable[A]])scala.collection.immutable.Iterable[A] with A with Int => Boolean""")}

}