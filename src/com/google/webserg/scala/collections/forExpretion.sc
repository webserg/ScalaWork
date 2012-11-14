object forExpretion {
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
  val n = 7                                       //> n  : Int = 7
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))                   //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  type Occurrences = List[(Char, Int)]
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

  val l: List[(Char, Int)] = List(('a', 1), ('a', 2),('b', 1),('b', 2))
                                                  //> l  : List[(Char, Int)] = List((a,1), (a,2), (b,1), (b,2))

 // val llist = for ((k, v) <- l; j <- 1 to v) yield List((k, j))
  //llist flatMap (g=>llist) map (j=>(g,j))
  
 // l.foldLeft(Set(Set.empty[(Char, Int)])) { case (ps, el) => ps ++ ps.map(_ + el) }
     (l foldRight(List[Occurrences](Nil)) ) {
      case ((ch, tm), acc) =>  acc ::: (for { comb <- acc; n <- 1 to tm } yield (ch, n) :: comb)
    }                                             //> res2: List[forExpretion.Occurrences] = List(List(), List((b,1)), List((b,2)
                                                  //| ), List((b,1)), List((b,1), (b,1)), List((b,1), (b,2)), List((a,1)), List((
                                                  //| a,2)), List((a,1), (b,1)), List((a,2), (b,1)), List((a,1), (b,2)), List((a,
                                                  //| 2), (b,2)), List((a,1), (b,1)), List((a,2), (b,1)), List((a,1), (b,1), (b,1
                                                  //| )), List((a,2), (b,1), (b,1)), List((a,1), (b,1), (b,2)), List((a,2), (b,1)
                                                  //| , (b,2)), List((a,1)), List((a,1), (b,1)), List((a,1), (b,2)), List((a,1), 
                                                  //| (b,1)), List((a,1), (b,1), (b,1)), List((a,1), (b,1), (b,2)), List((a,1), (
                                                  //| a,1)), List((a,1), (a,2)), List((a,1), (a,1), (b,1)), List((a,1), (a,2), (b
                                                  //| Output exceeds cutoff limit. 
 // val lll = List(1,2,3,4,5)
  //1 :: lll
  //val k = ('a', 2)
	//k :: l
  l.foldLeft(List[(Char, Int)]()){
    (list, x) => (x) :: list
  }
  
    def compareArrays[A](arrs: List[Iterable[A]]) = arrs match {
    case a :: tail => {
      val set = a.foldLeft(Set[A]()) { _ + _ }
      tail.foldLeft(set) { _ -- _ }
    }

    case Nil => Nil
  }

}