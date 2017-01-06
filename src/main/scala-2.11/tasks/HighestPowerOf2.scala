package tasks

object HighestPowerOf2 extends App {
  def powerOf2(x:Int):Int = {
    if (x < 1) {
      1
    }
    else {
      var res =1
      var i = 0

      while(i < 32) {
        var cur = 1 << i

        if (cur > x) {
          return res
        }

        res = cur
        i += 1
      }

      res
    }
  }

  println(powerOf2(10))
  println(powerOf2(19))
  println(powerOf2(32))
}
