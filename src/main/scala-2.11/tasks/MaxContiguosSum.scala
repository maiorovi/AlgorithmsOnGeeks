package tasks

object MaxContiguosSum extends App {
  def findSum(xs:Array[Int]):Int = {
    var currentSum = 0
    var maxSum = Integer.MIN_VALUE

    var i = 0

    while ( i < xs.length) {
      if (currentSum + xs(i) > 0) {
        currentSum = currentSum + xs(i)
        maxSum = Math.max(maxSum, currentSum)
      } else {
        currentSum = 0
      }
      i = i + 1
    }

    maxSum
  }

  println(findSum(Array(-2, -3, 4, -1, -2, 1, 5, -3)))
}
