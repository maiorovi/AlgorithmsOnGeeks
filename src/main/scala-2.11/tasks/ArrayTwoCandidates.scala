package tasks

import scala.collection.mutable

object ArrayTwoCandidates extends App {
  def hasArrayTwoCandidates(input:Array[Int], numb:Int):List[(Int, Int)] = {
    val numbers = new mutable.HashMap[Int, Int]()
    (0 until input.length).foreach( i => numbers += ((input(i), i)))

    val list = new mutable.ListBuffer[(Int, Int)]
    var i = 0
    while ( i < input.length) {
      numbers.get(numb - input(i)) match {
        case Some(x) if i != x =>  if(!list.contains((input(x), input(i)))) list.+=((input(i), input(x))) //println(s"Pair: (${input(i)}, ${input(x)}) ")
        case _ => print("")
      }
      i = i + 1
    }
    list.toList
  }

  println(hasArrayTwoCandidates(Array(3,5,4,2,6), 8))

}
