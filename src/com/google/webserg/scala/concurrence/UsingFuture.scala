package com.google.webserg.scala.concurrence

object UsingFuture extends App {


  import java.util.concurrent.Executors
  import scala.concurrent.{ExecutionContext,
  Future}

  // We need to create the ExecutionContext, which we
  // can build from an existing ExecutorService from
  // plain ol' java.util.concurrent
  val execService = Executors.newCachedThreadPool()
  implicit val execContext =
    ExecutionContext.fromExecutorService(execService)

  val future = Future[String] {
    "Hello" + "World"
  }(execContext)
  future foreach println

  val futureFail = Future[String] {
    throw new IllegalArgumentException("exeption")
  }(execContext)
  import scala.util.{Try, Success, Failure}

  futureFail onComplete {
    case Success(s) => println(s)
    case Failure(t) => println("An error has occured: " + t.getMessage)
  }

  val l= future.map( s => Success(s))
//  val l3 = l.map(s=>String(s))
  val l2= future.value

  println(l)
  println(l2)

  val ss = future onComplete {
    case Success(s) => println(s)
    case Failure(t) => println("An error has occured: " + t.getMessage)
  }
  print("ss=")
  println(ss)

  val sss = future.map(s⇒Success(s)) recover { case t ⇒ Failure(t) }
  sss onSuccess  {
    case Success(s) => println(s + "sss on success")
  }

  futureFail.map( s ⇒ println(s) ) recover { case t ⇒ println(t) }
  val ns: Iterator[Int] = (1 to 3).iterator
  val attempts: Iterator[()=>Future[String]] = ns.map(_ => ()=> future)
  val failed: Future[String] = Future.failed(new Exception)
  var res = attempts.foldLeft(failed)((a, block) => a fallbackTo { block() })
  println(res)
  res.map( s=>println(s) )
//  var resresr = res onSuccess { case Success(s) => println(s) }

  execContext.shutdown()
}
