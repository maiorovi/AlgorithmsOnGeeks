package tasks

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class MaxThreeProductSuite extends FlatSpec with Matchers with BeforeAndAfter{

  var cut:MaxThreeProduct = _

  before {
    cut = new MaxThreeProduct
  }

  "When given array of legnth < 3" should "throw illegal agrument exception" in {
    an [IllegalArgumentException] should be thrownBy cut.maxProduct(Array(1,2))
  }

  "Max three product of array of all positive number" should "be equal to max three numbers product" in {
    cut.maxProduct(Array(1,2,3,4,5,6,7,8,9,10)) should equal(720)
  }

  "Max three product of array of all negative numbers" should "be equalt max three numbers product" in {
    cut.maxProduct(Array(-10,-9,-8,-7,-6,-5,-4)) should equal (-120)
  }

  "Max three product of all negative numbers except one" should "be equal to two minimum product and one maximum" in {
      cut.maxProduct(Array(-10, -9, -8, -7, -6, -5, 10)) should be(900)
  }
}
