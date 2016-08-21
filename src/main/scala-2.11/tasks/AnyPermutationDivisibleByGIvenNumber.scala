package tasks

import scala.collection.mutable

object AnyPermutationDivisibleByGivenNumber extends App {

  def isPermutationDivisible(number: Int, divisor: Int): List[String] = {
    findAllPermutationsOfGivenNumber(number).filter( _ % 8 == 0).map( _.toString)
  }

  private def findAllPermutationsOfGivenNumber(n:Int):List[Int] = {
    val stringifiedNumber = n.toString
    val size = stringifiedNumber.length
    var i = 0
    val list = mutable.Set[Int]()

    def loop(s:String, st:Int, end:Int):List[Int] = {
      if (st == end) {
        (list += (s.toInt) ).toList
      } else {
        var i = st
        while (i < end + 1) {
          var res = swap(s, st, i)
          loop(res, st + 1, end)
          res = swap(res, st, i)
          i = i + 1
        }
        list.toList
      }
    }

    loop(stringifiedNumber, 0,  size - 1)
  }

  private def swap(n:String, s:Int, e:Int):String = {
    val ch:Array[Char] = n.toCharArray
    val tmp = ch(s)
    ch(s) = ch(e)
    ch(e) = tmp

    new String(ch)
  }

  def factorial(n:Int):Int = if (n == 0) 1 else n * factorial(n - 1)

  def gcd(a:Int, b:Int):Int = if (a % b == 0) b else gcd(b, a % b)

  private def defineDimensionOfNumber(n:Int):Int = {
    var dimension = 1
    var number = n
    while (number > 1) {
      dimension = dimension + 1
      number = number / 10
    }

    return dimension
  }

  println(defineDimensionOfNumber(13500))
  println(factorial(5))

  println(gcd(24, 30))

  println(findAllPermutationsOfGivenNumber(135))

  println(isPermutationDivisible(642, 5))
}
