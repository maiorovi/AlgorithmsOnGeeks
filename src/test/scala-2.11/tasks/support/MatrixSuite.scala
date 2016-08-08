package tasks.support

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class MatrixSuite extends FlatSpec with Matchers with BeforeAndAfter {

  var matrix: Matrix = _
  val dimension = 5

  before {
   matrix = Matrix(dimension, dimension)
  }

  "A empty matrix" should "be filled with zeroes" in {
    (0 until 5).foreach( i => (0 until 5).foreach( j => matrix(i, j) should be (0)))
  }

  "An update method" should "updates element value at given position" in {
    matrix(4,4) = 25

    matrix(4,4) should be (25)
  }


}
