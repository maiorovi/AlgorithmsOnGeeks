package tasks

import java.util

import scala.collection.mutable


object GeneratePrintBinaries extends App {
  def generatePrintBinaries(n:Int):mutable.MutableList[String] = {
    var list = new mutable.MutableList[String]()
    val queue = new util.LinkedList[String]()
    queue.addLast("1")
    var i = 0

    while ( i < n) {
      val tmp = queue.remove().toString
      list.+=(tmp)
      queue.addLast(tmp + "0")
      queue.addLast(tmp + "1")
      i = i + 1
    }

    list
  }


  println(generatePrintBinaries(5))
}
