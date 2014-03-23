package com.google.webserg.scala.patterns.strategy

/**
 * Created by webserg on 24.02.14.
 * In object-oriented programming, the decorator pattern (also known as Wrapper, an alternative naming shared with
 * the Adapter pattern) is a design pattern that allows behavior to be added to an individual object, either
 * statically or dynamically, without affecting the behavior of other objects from the same class.[1]
 */
object UseDecorator {
  trait OutputStream {
    def write(b: Byte)
    def write(b: Array[Byte])
  }

  class FileOutputStream(path: String) extends OutputStream {
  /* ... */
    def write(b: Byte): Unit = ???

    def write(b: Array[Byte]): Unit = ???
  }

  trait Buffering extends OutputStream {
    abstract override def write(b: Byte) {
      // ...
      super.write(b)
    }

    new FileOutputStream("foo.txt") with Buffering // with Filtering, ...
  }

}
