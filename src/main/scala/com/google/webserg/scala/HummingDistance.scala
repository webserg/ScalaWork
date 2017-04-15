package com.google.webserg.scala

/**
  * Created by webse on 2/20/2017.
  *
  * alculate the Hamming difference between two DNA strands.
  * *
  * A mutation is simply a mistake that occurs during the creation or copying of a nucleic acid, in particular DNA. Because
  * nucleic acids are vital to cellular functions, mutations tend to cause a ripple effect throughout the cell. Although mutations are
  * technically mistakes, a very rare mutation may equip the cell with a beneficial attribute. In fact, the macro effects of evolution are
  * attributable by the accumulated result of beneficial microscopic mutations over many generations.
  * *
  * The simplest and most common type of nucleic acid mutation is a point mutation, which replaces one base with another at a single nucleotide.
  * *
  * By counting the number of differences between two homologous DNA strands taken from different genomes with a common ancestor,
  * we get a measure of the minimum number of point mutations that could have occurred on the evolutionary path between the two strands.
  * *
  * This is called the 'Hamming distance'.
  * *
  * It is found by comparing two DNA strands and counting how many of the nucleotides are different from their equivalent in the other string.
  * *
  * 1
  * 2
  * 3
  * GAGCCTACTAACGGGAT
  * CATCGTAATGACGGCCT
  * ^ ^ ^  ^ ^    ^^
  *
  * Step 1
  * Ensure the two strings are of equal length. The Hamming distance can only be calculated between two strings of equal length.
  * String 1: "1001 0010 1101" String 2: "1010 0010 0010"
  * *
  * Step 2
  * Compare the first two bits in each string. If they are the same, record a "0" for that bit. If they are different,
  * record a "1" for that bit. In this case, the first bit of both strings is "1," so record a "0" for the first bit.
  * *
  * Step 3
  * Compare each bit in succession and record either "1" or "0" as appropriate.
  * String 1: "1001 0010 1101"
  * String 2: "1010 0010 0010"
  * Record: "0011 0000 1111"
  * *
  * Step 4
  * Add all the ones and zeros in the record together to obtain the Hamming distance. Hamming distance = 0+0+1+1+0+0+0+0+1+1+1+1 = 6
  * *
  * Tip
  * If using a computer, "XOR" can be used to compare the two strings and obtain the "record."
  *
  */
object HummingDistance extends App {
  val s = "karolin"
  val s2 = "kathrin"
  s.zip(s2)
  (for ((x, y) <- s.zip(s2) if x != y) yield 1).length

}
