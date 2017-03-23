package com.google.webserg.scala.collections
object combinations {
  println("Welcome to the Scala worksheet")//> Welcome to the Scala worksheet
    type Occurrences = List[(Char, Int)]

  val l: List[(Char, Int)] = List( ('a', 2), ('b', 2))
                                                  //> l  : List[(Char, Int)] = List((a,2), (b,2))

  // val llist = for ((k, v) <- l; j <- 1 to v) yield List((k, j))
  //llist flatMap (g=>llist) map (j=>(g,j))

  // l.foldLeft(Set(Set.empty[(Char, Int)])) { case (ps, el) => ps ++ ps.map(_ + el) }
  val ll:List[Occurrences] = List[Occurrences](Nil)
                                                  //> ll  : List[combinations.Occurrences] = List(List())
 val ll2 = (for {comb <- ll; n <- 1 to 2 } yield ('a', n) :: comb)
                                                  //> ll2  : List[List[(Char, Int)]] = List(List((a,1)), List((a,2)))
  (for { comb <- ll2; n <- 1 to 2 } yield ('b', n) :: comb)
                                                  //> res0: List[List[(Char, Int)]] = List(List((b,1), (a,1)), List((b,2), (a,1)),
                                                  //|  List((b,1), (a,2)), List((b,2), (a,2)))
  
  (l foldRight (List[Occurrences](Nil))) {
    case ((ch, tm), acc) => acc ::: (for { comb <- acc; n <- 1 to tm } yield (ch, n) :: comb)
  }                                               //> res1: List[combinations.Occurrences] = List(List(), List((b,1)), List((b,2))
                                                  //| , List((a,1)), List((a,2)), List((a,1), (b,1)), List((a,2), (b,1)), List((a,
                                                  //| 1), (b,2)), List((a,2), (b,2)))
  // val lll = List(1,2,3,4,5)
  //1 :: lll
  //val k = ('a', 2)
  //k :: l
  l.foldLeft(List[(Char, Int)]()) {
    (list, x) => (x) :: list
  }                                               //> res2: List[(Char, Int)] = List((b,2), (a,2))
  
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