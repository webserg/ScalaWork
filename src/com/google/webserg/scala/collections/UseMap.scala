package com.google.webserg.scala.collections

/**
 * User: Sergiy Doroshenko
 * Date: Nov 15, 2010 4:26:24 PM

• You need to choose between mutable and immutable maps
• By default, you get a hash map, but you can also get a tree map
• You can easily convert between Scala and Java maps
 */

object UseMap extends App{
  	val scores1 = Map("Alise" -> 10,"Bob" ->3 ,"Kindy" -> 8)
  	//if you want mutable map 
    val treasureMap = scala.collection.mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))

    //if you want to start with blank map you need to choose implementation
    val scores2 = new scala.collection.mutable.HashMap[String, Int]

    val scores3 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

    val bobsScore = scores3("Bob") // like scores.get("Bob") in Java, vey close to functions

    val bobsScore2 = if(scores3.contains("Bob")) scores3("Bob") else 0
    //shirtcat
    val bobsScore3 = scores3.getOrElse("Bob", 0)
    //Finally, the call map.get(key) returns an Option object that is either Some(value for key)
	//or None. We discuss the Option class in the “Pattern Matching and Case Classes” chapter

	val scoresMute = scala.collection.mutable.Map("Alice" -> 10,"Bob" ->3 ,"Kindy" -> 8)
	//in mutable Maps
	scoresMute("Bob") = 10 // Updates the existing value for the key "Bob", assuming scores is mutable
	scoresMute("Fred") = 7 // Adds a new key/value pair to scores (assuming it is mutable)
	println(scoresMute)
	scoresMute += ("Bob" -> 3, "Fred" -> 4)
	println(scoresMute)
	scoresMute -= "Alice" // remove
	println(scoresMute)

	//You can't update an immutable map, but you can do something that's just as
	//useful—obtain a new map that has the desired update.
	val newScores = scores3 + ("Bob" -> 10, "Fred" -> 7) // New map with update
	print(scores3)
	print(" new Map ")
	println(newScores)

	//for ((k, v) <- map) process k and v
	val switchMap = for ((k, v) <- newScores) yield (v, k) // switch value and key
    for ((k, v) <- switchMap) print("(" + k + "->" +v+")")
    println
    for (v <- scores3.values) print(v + " ") //print values
    println
    for (k <- scores3.keySet) print(k + " ") //print  keys
    println
    //java to scala 
    import scala.collection.JavaConversions.mapAsScalaMap
    val scores: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]

    val list = List("neo","smith","trinity")
    val f:String => List[Int] = s=> s.map(_.toInt).toList
     

}