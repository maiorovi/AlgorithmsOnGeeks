package tasks.support

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class IntMatrixSuite extends FlatSpec with Matchers with BeforeAndAfter {

  var matrix: IntMatrix = _
  val dimension = 5

  before {
   matrix = IntMatrix(dimension, dimension)
  }

  "A empty matrix" should "be filled with zeroes" in {
    (0 until 5).foreach( i => (0 until 5).foreach( j => matrix(i, j) should be (0)))
  }

  "An update method" should "updates element value at given position" in {
    matrix(4,4) = 25

    matrix(4,4) should be (25)
  }

  "When given two dimensional array" should "construct matrix from it" in {
    val c = Array(
      Array(10,20,30,40),
      Array(15,25,35,45),
      Array(27,29,37,48),
      Array(32,33,39,50)
    )

    matrix = new IntMatrix(c)

    matrix(3,3) should be (50)
  }


}
