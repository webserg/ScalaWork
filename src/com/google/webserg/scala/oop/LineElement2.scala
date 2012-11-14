package com.google.webserg.scala.oop

/**
 * Created by sergiy.doroshenko
 * Date: 5/12/11 
 */
//Invoking superclass constructors
class LineElement2(s:String) extends ArrayElement2(Array(s)){
  def weight = s.length
  override def height = 1
}