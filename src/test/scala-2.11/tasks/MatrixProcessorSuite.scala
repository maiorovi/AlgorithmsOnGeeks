package tasks

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import tasks.support.IntMatrix

class MatrixProcessorSuite extends FlatSpec with Matchers with BeforeAndAfter{
  trait InitialMatrix {
    private val c = Array(
      Array(10,20,30,40),
      Array(15,25,35,45),
      Array(27,29,37,48),
      Array(32,33,39,50)
    )

    val matrix:IntMatrix = new IntMatrix(c)
  }

  var matrixProcessor: MatrixProcessor = _

  before {
    matrixProcessor = new MatrixProcessor
  }

  "A matrix" should "return true when request for elem which it contains" in {
    new InitialMatrix {
      matrixProcessor.isPresentInMatrix(matrix, 10) should be(true)
      matrixProcessor.isPresentInMatrix(matrix, 50) should be(true)
      matrixProcessor.isPresentInMatrix(matrix, 27) should be(true)
      matrixProcessor.isPresentInMatrix(matrix, 33) should be(true)
      matrixProcessor.isPresentInMatrix(matrix, 29) should be(true)
    }
  }

  "A matrix" should "return false when request for elem which it doesnt contains" in {
    new InitialMatrix {
      matrixProcessor.isPresentInMatrix(matrix, -50) should be(false)
      matrixProcessor.isPresentInMatrix(matrix, 11) should be(false)
      matrixProcessor.isPresentInMatrix(matrix, 151) should be(false)
    }
  }




}
