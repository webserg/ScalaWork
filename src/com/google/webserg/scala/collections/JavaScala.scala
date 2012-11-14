package com.google.webserg.scala.collections
import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
/**
Since Scala arrays are implemented as Java arrays, you can pass them back and forth
between Java and Scala.
If you call a Java method that receives or returns a java.util.List, you could of course
use a Java ArrayList in your Scala code, but that is unattractive. Instead, import the
implicit conversion methods in scala.collection.JavaConversions. Then you can use
Scala buffers in your code, and they automatically get wrapped intoJava lists when
calling a Java method.
*/
object JavaScala extends App{
	val commands = scala.collection.mutable.ArrayBuffer("ls", "-al", "/home/cay")
	//val pb = new ProcessBuilder(Buffer("ls", "-al", "/home/cay")) // Scala to Java
	val pb = new ProcessBuilder(commands) // Scala to Java
	val cmds : Buffer[String] = pb.command() // Java to Scala

	//import scala.collection.JavaConversions.asJavaList
	// Or simply import collection.JavaConversions._
	//val commands = scala.collection.mutable.ArrayBuffer("ls", "-al", "/home/cay")
	//val pb = new ProcessBuilder(commands)

	//import scala.collection.JavaConversions.asScalaBuffer
	//val cmds : scala.collection.mutable.Buffer[String] = pb.commands()
	// You can't use ArrayBuffer—the wrapped object is only guaranteed to be a Buffer
	println(cmds)
}