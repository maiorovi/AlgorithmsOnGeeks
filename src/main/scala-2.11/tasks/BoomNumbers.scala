package tasks

import java.util

object BoomNumbers extends App {

  def nthBoomNumber(n:Int):String = {
    val queue = new util.LinkedList[String]
    queue.addLast("2")
    queue.addLast("3")

    var i = 1
    while (i < n) {
      var tmp = queue.remove()
      queue.add(tmp + "2")
      queue.add(tmp + "3")
      i = i + 1
    }

    queue.remove()
  }

  println(nthBoomNumber(1))
  println(nthBoomNumber(2))
  println(nthBoomNumber(5))
  println(nthBoomNumber(100))
  println(nthBoomNumber(1000000))
//  Input : k = 2
//  Output: 3
//
//  Input : k = 3
//  Output: 22
//
//  Input : k = 100
//  Output: 322323
//
//  Input: k = 1000000
//  Output: 3332322223223222223
}
