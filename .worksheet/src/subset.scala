object subset {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(69); 

  val l = List(('a', 1), ('a', 2),('b', 1),('b', 2));System.out.println("""l  : List[(Char, Int)] = """ + $show(l ));$skip(122); 
 val ls:List[Set[(Char,Int)]] =  l.foldLeft(Set(Set.empty[(Char, Int)])) { case (ps, el) => ps ++ ps.map(_ + el) } toList;System.out.println("""ls  : List[Set[(Char, Int)]] = """ + $show(ls ));$skip(191); 
def isOk(l:List[(Char,Int)]):Boolean = l match{
case Nil => true
case head::tail => if(tail.length > 1) false else if(tail.isEmpty){ true}else{ if(tail.head._1 == head._1) false else true}
};System.out.println("""isOk: (l: List[(Char, Int)])Boolean""");$skip(36); val res$0 = 
 
ls.map{_.toList} filter (isOk(_));System.out.println("""res0: List[List[(Char, Int)]] = """ + $show(res$0))}
}