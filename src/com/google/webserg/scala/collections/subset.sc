object subset {

  val l = List(('a', 1), ('a', 2),('b', 1),('b', 2))
                                                  //> l  : List[(Char, Int)] = List((a,1), (a,2), (b,1), (b,2))
 val ls:List[Set[(Char,Int)]] =  l.foldLeft(Set(Set.empty[(Char, Int)])) { case (ps, el) => ps ++ ps.map(_ + el) } toList
                                                  //> ls  : List[Set[(Char, Int)]] = List(Set((a,1), (b,1), (b,2)), Set((a,2), (b,
                                                  //| 1), (b,2)), Set(), Set((b,1)), Set((a,1), (a,2), (b,1), (b,2)), Set((a,2), (
                                                  //| b,2)), Set((a,1), (a,2), (b,1)), Set((a,1), (a,2)), Set((a,1), (b,2)), Set((
                                                  //| a,2), (b,1)), Set((a,1), (b,1)), Set((a,2)), Set((b,2)), Set((b,1), (b,2)), 
                                                  //| Set((a,1)), Set((a,1), (a,2), (b,2)))
def isOk(l:List[(Char,Int)]):Boolean = l match{
case Nil => true
case head::tail => if(tail.length > 1) false else if(tail.isEmpty){ true}else{ if(tail.head._1 == head._1) false else true}
}                                                 //> isOk: (l: List[(Char, Int)])Boolean
 
ls.map{_.toList} filter (isOk(_))                 //> res0: List[List[(Char, Int)]] = List(List(), List((b,1)), List((a,2), (b,2))
                                                  //| , List((a,1), (b,2)), List((a,2), (b,1)), List((a,1), (b,1)), List((a,2)), L
                                                  //| ist((b,2)), List((a,1)))
}