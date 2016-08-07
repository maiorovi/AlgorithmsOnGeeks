package tasks

import org.scalatest.{FlatSpec, Matchers}

class BinarySearchSuite extends FlatSpec with Matchers {

  "When digit is present in array" should "return true" in {
    val bs = BinarySearch
    bs.search(Array(1,2,3,4,5,6,7,8), 3) should be (true)
  }

  "When digit is not present in array" should "return false" in {
    val bs = BinarySearch
    bs.search(Array(1,2,3,4,5,6,7,8), 10) should be (false)
  }

  "When looking for a 7 digit in array" should "return true" in {
    val bs = BinarySearch
    bs.search(Array(1,2,3,4,5,6,7,8), 7) should be (true)
  }

  "When looking for a left most digit in array" should "return true" in {
    val bs = BinarySearch
    bs.search(Array(1,2,3,4,5,6,7,8), 1) should be (true)
  }

  "When looking for a right most digit in array" should "return true" in {
    val bs = BinarySearch
    bs.search(Array(1,2,3,4,5,6,7,8), 8) should be (true)
  }

}
