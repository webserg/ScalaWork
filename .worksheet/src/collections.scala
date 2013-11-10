object collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(435); 
   def listMatch(list :List[Any]):List[Any] = list match{
      case x :: y :: List(xs,ys) ::zs => list :: List(0)
    //  case 5 :: 6 :: xs => list // list starts 1 2
    //  case x :: Nil => list //list of lenghts 1 List(x) the same
    //  case List(2 :: xs) =>xs //list contain	s another list starts with 2
    //  case p :: ps => ps // p head ps tail
     // case Nil => list
        case List() => list
    };System.out.println("""listMatch: (list: List[Any])List[Any]""");$skip(26); 
    val a = List(1, 2, 4);System.out.println("""a  : List[Int] = """ + $show(a ));$skip(26); 
    val b = List(4, 5, 6);System.out.println("""b  : List[Int] = """ + $show(b ));$skip(76); 
    //println(listMatch(a))
    val k = List(List(1,2),List(1,2),List(1,2));System.out.println("""k  : List[List[Int]] = """ + $show(k ));$skip(26); 
    println(listMatch(k));$skip(33); 
    
    val amap = a map {_ *2};System.out.println("""amap  : List[Int] = """ + $show(amap ));$skip(47); 
    
    val flmap = a flatMap (c=> List(0,c));System.out.println("""flmap  : List[Int] = """ + $show(flmap ));$skip(51); 
    val flmapScal = a flatMap(x=>b map (y=>(x,y)));System.out.println("""flmapScal  : List[(Int, Int)] = """ + $show(flmapScal ));$skip(12); val res$0 = 
    a zip b;System.out.println("""res0: List[(Int, Int)] = """ + $show(res$0));$skip(13); 
    val n =7;System.out.println("""n  : Int = """ + $show(n ));$skip(117); 
 //   (1 until n) map (i=>(1 until i) map (j=>(i,j)))
   def isPrime(n:Int):Boolean= (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(120); val res$1 = 
   // ((1 until n) map (i=>(1 until i) map (j=>(i,j)))).flatten
    (1 until n) flatMap (i=>(1 until i) map (j=>(i,j)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(115); val res$2 = 
    
    (1 until n) flatMap (i=>
    (1 until i) map (j=>(i,j))) filter (pair =>
     isPrime(pair._1 + pair._2));System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2))}
}
