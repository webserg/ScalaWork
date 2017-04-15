package com.google.webserg.scala.expressions

/**
  * @author Sergiy Doroshenko
  *         email:webserg@gmail.com
  *         Date: 4/3/11 9:45 PM
  *
  *         int i = 0; // This is Java
  *         boolean foundIt = false;
  *         while (i < args.length) {
  *         if (args[i].startsWith(""))
  *         {
  *         i = i + 1;
  *         continue;
  *         }
  *         if (args[i].endsWith(".scala")) {
  *         foundIt = true;
  *         break;
  *         }
  *         *
  *         i = i + 1;
  *         }
  */

object Search extends App {
  val list = "one" :: "-two.scala" :: "three.scala" :: "scala.c" :: Nil

  def searchFrom(i: Int): Int =
    if (i >= list.length) 1
    else if (args(i).startsWith("-"))
      searchFrom(i + 1)
    else if (list(i).endsWith(".scala")) i
    else searchFrom(i + 1)

  val i = searchFrom(0)

  println(i)
}