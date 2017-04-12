package com.google.webserg.scala.patterns.strategy

/**
  * Created by webserg on 23.02.14.
  * In computer programming, the adapter pattern (often referred to as the wrapper pattern or simply a
  * wrapper - an alternative naming shared with the Decorator pattern according to the GoF Design Patterns book)
  * is a design pattern that translates one interface for a class into a compatible interface.[1] An adapter allows
  * classes to work together that normally could not because of incompatible interfaces, by providing its interface
  * to clients while using the original interface. The adapter translates calls to its interface into calls to the
  * original interface, and the amount of code necessary to do this is typically small.
  */

import java.util.logging.Level._
import java.util.logging.Level

object UseAdapter extends App {

  trait Log {
    def warning(message: String)

    def error(message: String)
  }

  final class Logger {


    def log(level: Level, message: String) {
      /* ... */
    }
  }

  implicit class LoggerToLogAdapter(logger: Logger) extends Log {
    def warning(message: String) {
      logger.log(WARNING, message)
    }

    def error(message: String) {
      logger.log(INFO, message)
    }
  }

  val log: Log = new Logger()

}
