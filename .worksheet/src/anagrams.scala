object anagrams {
type Word = Stringimport scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 
  val w: Word = "abRRRRcdBFFFfff";System.out.println("""w  : anagrams.Word = """ + $show(w ));$skip(35); val res$0 = 
  w.toList.sorted groupBy (c => c);System.out.println("""res0: scala.collection.immutable.Map[Char,List[Char]] = """ + $show(res$0));$skip(73); val res$1 = 
  (w.toList.sorted groupBy (_.toLower) mapValues (_.size)).toList sorted
 type Occurrences = List[(Char, Int)];System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(145); 
  def wordOccurrences(w: Word): Occurrences = (w.toList.sorted groupBy (c => c) mapValues (_.size)) toList;System.out.println("""wordOccurrences: (w: anagrams.Word)anagrams.Occurrences""");$skip(22); val res$2 = 

  wordOccurrences(w);System.out.println("""res2: anagrams.Occurrences = """ + $show(res$2))}
}