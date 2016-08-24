package tasks

object NextGreaterNumberWithTheSameDigits extends App {


  def findGreaterNumberWithTheSameDigits(numb:Int):String = {
    val digits = numb.toString.toCharArray
    if (!isNumberExists(digits)) {
      return "impossible"
    }

    val (str, ind) = enlargeNumber(digits)

    str.substring(0, ind+1) + minimizeNumber(str.substring(ind+1,str.length).toCharArray)
  }

  private def isNumberExists(numb:Array[Char]):Boolean = {
    val last = numb(numb.length - 1)
    !numb.init.forall( c => c > last)
  }

  private def enlargeNumber(numb:Array[Char]): (String, Int) = {
    val last = numb(numb.length - 1).toInt
    var i = numb.length - 2

    while(numb(i) >= last) {
      i = i - 1
    }

    (swap(numb, i, numb.length - 1).mkString(""), i)
  }

  private def minimizeNumber(numb:Array[Char]):String = {
    numb.map(_.toInt).sorted.map(_.toChar).mkString("")
  }

  private def swap(numb:Array[Char], start:Int, end:Int):Array[Char] = {
    val tmp = numb(start)
    numb(start) = numb(end)
    numb(end) = tmp
    numb
  }

  println(findGreaterNumberWithTheSameDigits(218765)) //251678
  println(findGreaterNumberWithTheSameDigits(4321)) // not possible
  println(findGreaterNumberWithTheSameDigits(1234)) // 1243
  println(findGreaterNumberWithTheSameDigits(534976)) // 536479

}
