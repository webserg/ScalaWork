package com.google.webserg.scala.collections

/**
 * Created by webserg on 16.01.14.
 */
class PointEq(var x: Int, var y: Int) extends Equals {
  def move(mx: Int, my: Int): Unit = {
    x = x + mx
    y = y + my
  }

  override def hashCode(): Int = y + (31 * x)

  def canEqual(that: Any): Boolean = that match {
    case p: PointEq => true
    case _ => false
  }

  override def equals(that: Any): Boolean = {
    def strictEquals(other: PointEq) =
      this.x == other.x && this.y == other.y
    that match {
      case a: AnyRef if this eq a => true
      case p: PointEq => (p canEqual this) && strictEquals(p)
      case _ => false
    }
  }
}
