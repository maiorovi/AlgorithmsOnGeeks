package tasks

object CalculateDepthOfFullBinaryTreeFromPreorder extends App {
  def findDepth(input:String):Double = {
    def loop(inp: Array[Char], index:Int):Double = {
      if (inp(index) == 'l' || index >= inp.length) {
        return 0
      }

      Math.max(loop(inp, index+1), loop(inp, index + 2)) + 1
    }

    loop(input.toCharArray, 0)
  }


  println(findDepth("nlnll"))
  println(findDepth("nlnnlll"))

}
