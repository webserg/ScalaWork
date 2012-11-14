object mapUsing {
 val m = Map("I" -> 1,"V" -> 5,"X" -> 10)         //> m  : scala.collection.immutable.Map[java.lang.String,Int] = Map(I -> 1, V -> 
                                                  //| 5, X -> 10)
 val capitals = Map("Italy"->"Roma","Switserland"->"Bern","US"->"Washington")
                                                  //> capitals  : scala.collection.immutable.Map[java.lang.String,java.lang.String
                                                  //| ] = Map(Italy -> Roma, Switserland -> Bern, US -> Washington)
 def showC(capital:String) = capitals.get(capital) match {
 case Some(capital) => capital
 case None => "non"
 }                                                //> showC: (capital: String)java.lang.String
 
  val fruit = List("apple","fruit","pear","orange","pineapple")
                                                  //> fruit  : List[java.lang.String] = List(apple, fruit, pear, orange, pineapple
                                                  //| )
 //fruit sortWith (_.length > _.length)
 //fruit.sorted
fruit groupBy (_.head)                            //> res0: scala.collection.immutable.Map[Char,List[java.lang.String]] = Map(a ->
                                                  //|  List(apple), f -> List(fruit), o -> List(orange), p -> List(pear, pineapple
                                                  //| ))
 
  type Occurrences = List[(Char, Int)]
 type Word = String
   type Sentence = List[Word]
 val w:Word = "abRRRRcdBFFFfff"                   //> w  : mapUsing.Word = abRRRRcdBFFFfff
 //w.toList.sorted groupBy(c=>c)
 
 val (ex, coeff) = (w.toList.sorted groupBy(_.toLower) filter (_._2.exists(x => x == 'F'))).head
                                                  //> ex  : Char = f
                                                  //| coeff  : List[Char] = List(F, F, F, f, f, f)
 
 def wordOccurrences(w: Word): Occurrences = (w.toList.sorted groupBy(c=>c) mapValues( _.size )) toList
                                                  //> wordOccurrences: (w: mapUsing.Word)mapUsing.Occurrences
 //val defMap:Map[Char,Int] = Map.empty withDefaultValue 0
 //List[(Char, Int)](('d',1), ('d',2))
 
 //List("abcd","ddssff").flatMap(wordOccurrences(_))groupBy(_._1)mapValues( _.map(_._2) sum ) toList
 
 List("abcd","ddssff"). groupBy (_.size)          //> res1: scala.collection.immutable.Map[Int,List[java.lang.String]] = Map(4 ->
                                                  //|  List(abcd), 6 -> List(ddssff))

  List(('a', 5), ('a', 2)) filter (_._2 == 2)     //> res2: List[(Char, Int)] = List((a,2))
 
}