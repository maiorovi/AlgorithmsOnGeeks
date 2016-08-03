package tasks

object SumOfNumbersInString extends App {
  def sumOfNumberInString(s: String): Int = s.split("\\D+").map(d => if (d.isEmpty) 0 else d.toInt).sum

  def isDigit(c:Char):Boolean = c.isDigit
}
