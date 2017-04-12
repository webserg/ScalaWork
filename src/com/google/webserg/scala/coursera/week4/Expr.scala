package com.google.webserg.scala.coursera.week4

trait Expr {
  def isNumber: Boolean

  def isSum: Boolean

  def numValue: Int

  def leftOp: Expr

  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true

  def isSum: Boolean = false

  def numValue = n

  def leftOp: Expr = throw new Error()

  def rightOp: Expr = throw new Error()
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false

  def isSum: Boolean = true

  def numValue = throw new Error()

  def leftOp: Expr = e1

  def rightOp: Expr = e2

}

object ExprMain extends App {
  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error()
  }

  def eval2(e: Expr): Int = {
    if (e.isInstanceOf[Number]) e.numValue
    else if (e.isInstanceOf[Sum]) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error()
  }

  assert(eval(new Sum(new Number(1), new Number(2))) == 3)
  assert(eval2(new Sum(new Number(1), new Number(2))) == 3)
}