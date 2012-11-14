object subtruck {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  val lard = List(('j', 1), ('i', 1), ('m', 2), ('y', 1));System.out.println("""lard  : List[(Char, Int)] = """ + $show(lard ));$skip(36); 
    val r = List(('m', 1),('y', 1));System.out.println("""r  : List[(Char, Int)] = """ + $show(r ));$skip(77); 
    
  val  m1: Map[Char,(Char, Int)] =lard groupBy (_._1) mapValues(_.head);System.out.println("""m1  : Map[Char,(Char, Int)] = """ + $show(m1 ));$skip(75); 
    
   val m2: Map[Char,(Char, Int)]=  r groupBy (_._1) mapValues(_.head);System.out.println("""m2  : Map[Char,(Char, Int)] = """ + $show(m2 ));$skip(148); 
  def f2(o:(Char, Int)):(Char, Int) = {
   		if(m2.contains(o._1)){
   		val occur = m2.get(o._1).get
   		(o._1,o._2 - occur._2)
   		}else o
   };System.out.println("""f2: (o: (Char, Int))(Char, Int)""");$skip(100); val res$0 = 
  m1.foldLeft(List[(Char, Int)]()) {
    (list, x) => f2(x._2) :: list
  } filter {_._2 > 0} sorted;System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(333); 
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
   };System.out.println("""f: (o: (Char, Int))Boolean""");$skip(55); val res$1 = 
   
   
   
   m1.filter { case (k,v) => f(v) } values;System.out.println("""res1: Iterable[(Char, Int)] = """ + $show(res$1))}
   
   
}