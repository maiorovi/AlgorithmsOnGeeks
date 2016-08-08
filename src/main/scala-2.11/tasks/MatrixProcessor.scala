package tasks

import tasks.support.{IntMatrix}

class MatrixProcessor {

  def isPresentInMatrix(matrix:IntMatrix, elem:Int): Boolean = {
    val leftTopCorner:Tuple2[Int, Int] = (0, matrix.col - 1)
    def find(cRow:Int, cColumn:Int): Boolean = elem match {
      case _ if isOutOfLimits(cRow, cColumn) => false
      case _ if (elem < matrix(cRow, cColumn)) => find(cRow, cColumn - 1)
      case _ if (elem > matrix(cRow, cColumn)) => find(cRow+1, cColumn)
      case _ if (elem == matrix(cRow, cColumn)) => true
    }

    def isOutOfLimits(cRow:Int, cColumn:Int):Boolean = (cRow < 0 || cRow >= matrix.row) || (cColumn < 0 || cColumn >= matrix.col)

    find(0, matrix.col - 1)
  }
}
