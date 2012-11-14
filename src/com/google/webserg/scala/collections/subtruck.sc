object subtruck {
  val lard = List(('j', 1), ('i', 1), ('m', 2), ('y', 1))
                                                  //> lard  : List[(Char, Int)] = List((j,1), (i,1), (m,2), (y,1))
    val r = List(('m', 1),('y', 1))               //> r  : List[(Char, Int)] = List((m,1), (y,1))
    
  val  m1: Map[Char,(Char, Int)] =lard groupBy (_._1) mapValues(_.head)
                                                  //> m1  : Map[Char,(Char, Int)] = Map(j -> (j,1), i -> (i,1), m -> (m,2), y -> (
                                                  //| y,1))
    
   val m2: Map[Char,(Char, Int)]=  r groupBy (_._1) mapValues(_.head)
                                                  //> m2  : Map[Char,(Char, Int)] = Map(m -> (m,1), y -> (y,1))
  def f2(o:(Char, Int)):(Char, Int) = {
   		if(m2.contains(o._1)){
   		val occur = m2.get(o._1).get
   		(o._1,o._2 - occur._2)
   		}else o
   }                                              //> f2: (o: (Char, Int))(Char, Int)
  m1.foldLeft(List[(Char, Int)]()) {
    (list, x) => f2(x._2) :: list
  } filter {_._2 > 0} sorted                      //> res0: List[(Char, Int)] = List((i,1), (j,1), (m,1))
   //def adjust(y: (Char, Int)):  (Char, Int) = {
    //  val (exp, coeff) = y
     // if()
      //exp -> (coeff - m3(exp))
   // }
    //m1 map adjust
   //m1 - 'r'
   def f(o:(Char, Int)):Boolean = {
   		if(m2.contains(o._1)){
   		val occur = m2.get(o._1).get
   		if(occur._2 <= o._2) false
   		else true
   		}else true
   }                                              //> f: (o: (Char, Int))Boolean
   
   
   
   m1.filter { case (k,v) => f(v) } values        //> res1: Iterable[(Char, Int)] = MapLike((j,1), (i,1))
   
   
}