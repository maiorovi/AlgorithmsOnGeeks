package tasks

object CountNumbersWithSameFirstAndLastDigits extends App {

  def find(start:Int, end:Int): List[Int] = {
    (start to end).filter( x => isFstAndLstDigitsEqual(x)).toList

  }

  private def isFstAndLstDigitsEqual(x:Int):Boolean = {
    val desc = 10
    val lst = x % desc


    val fst = Integer.parseInt(x.toString.substring(0,1));


    lst == fst
  }

  println(find(7, 68))
  println(find(120, 130))
}
