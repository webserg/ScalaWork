object combinations {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  println("Welcome to the Scala worksheet")

  type Occurrences = List[(Char, Int)];$skip(98); 

  val l: List[(Char, Int)] = List( ('a', 2), ('b', 2));System.out.println("""l  : List[(Char, Int)] = """ + $show(l ));$skip(254); 

  // val llist = for ((k, v) <- l; j <- 1 to v) yield List((k, j))
  //llist flatMap (g=>llist) map (j=>(g,j))

  // l.foldLeft(Set(Set.empty[(Char, Int)])) { case (ps, el) => ps ++ ps.map(_ + el) }
  val ll:List[Occurrences] = List[Occurrences](Nil);System.out.println("""ll  : List[combinations.Occurrences] = """ + $show(ll ));$skip(67); 
 val ll2 = (for {comb <- ll; n <- 1 to 2 } yield ('a', n) :: comb);System.out.println("""ll2  : List[List[(Char, Int)]] = """ + $show(ll2 ));$skip(60); val res$0 = 
  (for { comb <- ll2; n <- 1 to 2 } yield ('b', n) :: comb);System.out.println("""res0: List[List[(Char, Int)]] = """ + $show(res$0));$skip(144); val res$1 = 
  
  (l foldRight (List[Occurrences](Nil))) {
    case ((ch, tm), acc) => acc ::: (for { comb <- acc; n <- 1 to tm } yield (ch, n) :: comb)
  };System.out.println("""res1: List[combinations.Occurrences] = """ + $show(res$1));$skip(145); val res$2 = 
  // val lll = List(1,2,3,4,5)
  //1 :: lll
  //val k = ('a', 2)
  //k :: l
  l.foldLeft(List[(Char, Int)]()) {
    (list, x) => (x) :: list
  };System.out.println("""res2: List[(Char, Int)] = """ + $show(res$2))}
  
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
  
}