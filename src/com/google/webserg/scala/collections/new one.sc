val s = "karolin"
val s2 = "kathrin"
s.zip(s2)
s.zip(s2)
(for((x,y) <- s.zip(s2) if x!=y) yield 1).length


