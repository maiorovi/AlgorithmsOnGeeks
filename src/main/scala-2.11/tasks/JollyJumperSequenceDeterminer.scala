package tasks

object JollyJumperSequenceDeterminer extends App {
  def isJollyJumperSeq(xs: Array[Int]): Boolean = xs.length match {
    case 0 => false
    case 1 => true
    case _ => {
      val n = xs.length - 1

      val tmp: Array[Boolean] = new Array[Boolean](n)
      var i = 0

      while (i < n) {
        val diff = Math.abs(xs(i) - xs(i+1)) - 1

        if (diff < n) {
          tmp(diff) = true
        }

        i += 1
      }

      tmp.forall(x => x)
    }
  }
}
