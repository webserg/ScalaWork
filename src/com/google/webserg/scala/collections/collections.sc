object collections {
   def listMatch(list :List[Any]):List[Any] = list match{
      case x :: y :: List(xs,ys) ::zs => list :: List(0)
    //  case 5 :: 6 :: xs => list // list starts 1 2
    //  case x :: Nil => list //list of lenghts 1 List(x) the same
    //  case List(2 :: xs) =>xs //list contain	s another list starts with 2
    //  case p :: ps => ps // p head ps tail
     // case Nil => list
        case List() => list
    }                                             //> listMatch: (list: List[Any])List[Any]
    val a = List(1, 2, 4)                         //> a  : List[Int] = List(1, 2, 4)
    val b = List(4, 5, 6)                         //> b  : List[Int] = List(4, 5, 6)
    //println(listMatch(a))
    val k = List(List(1,2),List(1,2),List(1,2))   //> k  : List[List[Int]] = List(List(1, 2), List(1, 2), List(1, 2))
    println(listMatch(k))                         //> List(List(List(1, 2), List(1, 2), List(1, 2)), 0)
    
    val amap = a map {_ *2}                       //> amap  : List[Int] = List(2, 4, 8)
    
    val flmap = a flatMap (c=> List(0,c))         //> flmap  : List[Int] = List(0, 1, 0, 2, 0, 4)
    val flmapScal = a flatMap(x=>b map (y=>(x,y)))//> flmapScal  : List[(Int, Int)] = List((1,4), (1,5), (1,6), (2,4), (2,5), (2,6
                                                  //| ), (4,4), (4,5), (4,6))
    a zip b                                       //> res0: List[(Int, Int)] = List((1,4), (2,5), (4,6))
    val n =7                                      //> n  : Int = 7
 //   (1 until n) map (i=>(1 until i) map (j=>(i,j)))
   def isPrime(n:Int):Boolean= (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
   // ((1 until n) map (i=>(1 until i) map (j=>(i,j)))).flatten
    (1 until n) flatMap (i=>(1 until i) map (j=>(i,j)))
                                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
    
    (1 until n) flatMap (i=>
    (1 until i) map (j=>(i,j))) filter (pair =>
     isPrime(pair._1 + pair._2))                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5))
}