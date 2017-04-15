package com.google.webserg.scala.algorithms

/**
  * Created by webse on 4/9/2017.
  */
object UsingImplicitClasses extends App {

  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }

      loop(x)
    }
  }

  5 times println("HI")
}
