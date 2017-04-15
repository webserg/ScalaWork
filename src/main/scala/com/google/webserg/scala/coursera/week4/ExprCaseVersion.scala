//package com.google.webserg.scala.coursera.week4

trait Expression

case class Numb(n: Int) extends Expression

case class S(e1: Expression, e2: Expression) extends Expression

//case class SumProvVar(e1: Int, e2: Var) extends Expression
case class Var(x: String)

case class SumProvVar(e1: Any, e2: Var)

case class Prod(e1: Any, e2: Var)

object ExprMainC extends App {
  //    def eval(e:Expr):Int={
  //    if(e.isNumber) e.numValue
  //    else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
  //    else throw new Error()
  //  } 
  def eval(e: Expression): Int = e match {
    case Numb(n) => n
    //case Numb(_) => _
    case S(Numb(1), x) => eval(Numb(1)) + eval(x)
    case S(e1, e2) => eval(e1) + eval(e2)
    //case S(Numb(2), x) => eval(Numb(2)) + eval(x)
    //else throw new Error()
  }

  def show(e: Expression): String = e match {
    case Numb(n) => n toString
    case S(e1, e2) => show(e1) + " + " + show(e2)
  }

  def showProdVarSum(e: Any): String = e match {
    case Var(n) => n toString
    case SumProvVar(e1: Prod, e2) => showProdVarSum(e1) + " + " + e2.x
    case SumProvVar(e1: Int, e2) => "(" + showProdVarSum(e1) + " + " + e2.x + ")"
    case Prod(e1, e2) => showProdVarSum(e1) + " * " + e2.x
    case i: Int => i toString
    case _ => ""
  }

  assert(eval(S(Numb(1), Numb(2))) == 3)
  println(show(S(Numb(1), Numb(2))))
  println(showProdVarSum(SumProvVar(Prod(5, Var("x")), Var("y"))))
  println(showProdVarSum(Prod(SumProvVar(2, Var("x")), Var("y"))))

}