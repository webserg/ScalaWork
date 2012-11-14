object mapUsing {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(59); 
 val m = Map("I" -> 1,"V" -> 5,"X" -> 10);System.out.println("""m  : scala.collection.immutable.Map[java.lang.String,Int] = """ + $show(m ));$skip(78); 
 val capitals = Map("Italy"->"Roma","Switserland"->"Bern","US"->"Washington");System.out.println("""capitals  : scala.collection.immutable.Map[java.lang.String,java.lang.String] = """ + $show(capitals ));$skip(113); 
 def showC(capital:String) = capitals.get(capital) match {
 case Some(capital) => capital
 case None => "non"
 };System.out.println("""showC: (capital: String)java.lang.String""");$skip(66); 
 
  val fruit = List("apple","fruit","pear","orange","pineapple");System.out.println("""fruit  : List[java.lang.String] = """ + $show(fruit ));$skip(79); val res$0 = 
 //fruit sortWith (_.length > _.length)
 //fruit.sorted
fruit groupBy (_.head)
 
  type Occurrences = List[(Char, Int)]
 type Word = String
   type Sentence = List[Word];System.out.println("""res0: scala.collection.immutable.Map[Char,List[java.lang.String]] = """ + $show(res$0));$skip(123); 
 val w:Word = "abRRRRcdBFFFfff";System.out.println("""w  : mapUsing.Word = """ + $show(w ));$skip(132); 
 //w.toList.sorted groupBy(c=>c)
 
 val (ex, coeff) = (w.toList.sorted groupBy(_.toLower) filter (_._2.exists(x => x == 'F'))).head;System.out.println("""ex  : Char = """ + $show(ex ));System.out.println("""coeff  : List[Char] = """ + $show(coeff ));$skip(106); 
 
 def wordOccurrences(w: Word): Occurrences = (w.toList.sorted groupBy(c=>c) mapValues( _.size )) toList;System.out.println("""wordOccurrences: (w: mapUsing.Word)mapUsing.Occurrences""");$skip(244); val res$1 = 
 //val defMap:Map[Char,Int] = Map.empty withDefaultValue 0
 //List[(Char, Int)](('d',1), ('d',2))
 
 //List("abcd","ddssff").flatMap(wordOccurrences(_))groupBy(_._1)mapValues( _.map(_._2) sum ) toList
 
 List("abcd","ddssff"). groupBy (_.size);System.out.println("""res1: scala.collection.immutable.Map[Int,List[java.lang.String]] = """ + $show(res$1));$skip(47); val res$2 = 

  List(('a', 5), ('a', 2)) filter (_._2 == 2);System.out.println("""res2: List[(Char, Int)] = """ + $show(res$2))}
 
}