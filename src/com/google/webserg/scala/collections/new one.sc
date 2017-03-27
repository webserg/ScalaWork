val s = "karolin"
val s2 = "kathrin"
s.zip(s2)
s.zip(s2)
(for((x,y) <- s.zip(s2) if x!=y) yield 1).length
//List((Some(0),Some(0)),(Some(0),Some(0))).flatMap(_=>_)
(None,Some(0))


