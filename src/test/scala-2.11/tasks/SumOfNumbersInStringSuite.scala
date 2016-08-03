package tasks

import org.scalatest.{FlatSpec, Matchers}

class SumOfNumbersInStringSuite extends FlatSpec with Matchers {


  "A sum of numbers of empty string" should "should be zero" in {
    val st = SumOfNumbersInString
    st.sumOfNumberInString("") should be (0)
  }

  "A sum of number of string without numbers" should "be zero" in {
    val st = SumOfNumbersInString
    st.sumOfNumberInString("qwerty") should be(0)
  }

  "A sum of string with one digit" should "be equal to this digit" in {
    val st = SumOfNumbersInString
    assert(st.sumOfNumberInString("1") == 1)
  }

  "A sum of digits in geeks4geeks string" should "be equal to four" in {
    val st = SumOfNumbersInString
    st.sumOfNumberInString("geeks4geeks") should be (4)
  }

  "A sum of digits in 1abc2x30yz67 string" should "be equal to 100" in {
    val st = SumOfNumbersInString
    st.sumOfNumberInString("1abc2x30yz67") should be (100)
  }

  "A sum of digits" should "be equal to 123" in {
    val st = SumOfNumbersInString
    st.sumOfNumberInString("123abc") should be (123)
  }
}
