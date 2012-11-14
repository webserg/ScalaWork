package com.google.webserg.scala.expressions

object Loops extends App{
  for(i <- 1 to 10) println(i)
   //for (int i = 10; i >= 0; i--) System.out.println(i);
  var i = 10 
  while(i > 0) {    
     println(i)
     i -= 1
  }

}