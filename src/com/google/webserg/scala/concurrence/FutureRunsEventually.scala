package com.google.webserg.scala.concurrence

import scala.concurrent.{ExecutionContext,
Future}
import ExecutionContext.Implicits.global

object FutureRunsEventually extends App{
  @volatile var totalA = 0
  val text = Future {
    "na" * 16 + "BATMAN!!!"
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'a'); println(totalA)
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'A'); println(totalA)
  }

}
