package tasks

class MaxThreeProduct {



  def maxProduct(input: Array[Int]):Int = {
    if (input.length < 3) {
      throw new IllegalArgumentException
    }
    val (maxThree, minTwo)  = findMaxThreeAndMinTwo(input)

    Math.max(maxThree(0) * maxThree(1) * maxThree(2), minTwo(0) * minTwo(1) * maxThree(0))
  }


  //TODO: should be used some algorithm which allows to find value in O(n)
  private def findMaxThreeAndMinTwo(input:Array[Int]):(Array[Int], Array[Int]) = {

    val arr = input.sorted

    ( Array(arr(arr.length -1 ), arr(arr.length - 2),  arr(arr.length - 3)), Array(arr(0), arr(1)))
  }

}
