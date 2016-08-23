package tasks

object MinValueArrayExpresion extends App {
  def minValueOfExpr(input:Array[Int]):Int = {
    var i = 0
    var j = input.length - 1
    var min:Int = Integer.MAX_VALUE
    var max:Int = Integer.MIN_VALUE

    while(i < input.length) {
      max = Math.max(Math.abs(input(i) - i), max)
      min = Math.min(Math.abs(input(j) - j), min)

      i = i + 1
      j = j - 1
    }

    max - min
  }

  println(minValueOfExpr(Array(4, 1 ,2 ,6 ,3)))
  println(minValueOfExpr(Array(4, 4 ,4 ,4 ,1)))
}
