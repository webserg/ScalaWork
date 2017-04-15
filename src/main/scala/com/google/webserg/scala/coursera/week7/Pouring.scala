package com.google.webserg.scala.coursera.week7

class Pouring(capacity: Vector[Int]) {
  type State = Vector[Int]
  val initState = capacity map (x => 0)

  trait Move {
    def change(state: State): State
  }

  case class Empty(glass: Int) extends Move {
    def change(state: State): State = state updated(glass, 0)
  }

  case class Fill(glass: Int) extends Move {
    def change(state: State): State = state updated(glass, capacity(glass))
  }

  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State): State = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated(from, state(from) - amount)
      state updated(to, state(to) + amount)
    }
  }


  val glasses = 0 until capacity.length

  val moves =
    (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))

  class Path(history: List[Move]) {
    def endState: State = trackState(history)

    def endState2: State = history.foldRight(initState)(_ change _) //the same in terms of foldRight
    def extend(move: Move) = new Path(move :: history)

    override def toString = (history.reverse mkString " ") + "-->" + endState2

    private def trackState(xs: List[Move]): State = xs match {
      case Nil => initState
      case move :: xss => move change trackState(xss)
    }
  }

  val initPath = new Path(Nil)

  def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
    if (paths.isEmpty) Stream.empty
    else {
      val more = for {
        path <- paths
        next <- moves map path.extend
        if !(explored contains next.endState2)
      } yield next
      paths #:: from(more, explored ++ (more map (_.endState2)))
    }
  }

  val pathSets = from(Set(initPath), Set(initState))

  def solutions(target: Int): Stream[Path] =
    for {pathSet <- pathSets
         path <- pathSet
         if path.endState2 contains target
    } yield path

}