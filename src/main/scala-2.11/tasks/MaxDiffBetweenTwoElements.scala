package tasks

object MaxDiffBetweenTwoElements extends App {
  // we can do it in n*log(n) via sorting but I want to find a better solution which takes o(n)
  def maxDiff(input: Array[Int]):Int = {
    var maxSoFar = Integer.MIN_VALUE
    var minSoFar = Integer.MAX_VALUE
    var maxSum = Integer.MIN_VALUE
    var wasMinUpdated = false

    var i = 0

    while(i < input.length) {
      maxSoFar = Math.max(maxSoFar, input(i))
      if (minSoFar > input(i)) {
        minSoFar = input(i)
        maxSoFar = Integer.MIN_VALUE
      } else {
        maxSum = Math.max(maxSum, maxSoFar - minSoFar)
      }

      i = i + 1
    }

    maxSum
  }

  println(maxDiff(Array(2, 3, 10, 6, 4, 8, 1)))
  println(maxDiff(Array(7, 9, 5, 6, 3, 2)))
}
