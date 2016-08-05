package tasks

import org.scalatest.{FlatSpec, Matchers}

class JollyJumperSequenceDeterminerTest extends FlatSpec with Matchers {

  "An empty sequence" should "not be considered as jolly jumper" in {
    val jmpr = JollyJumperSequenceDeterminer
    jmpr.isJollyJumperSeq(Array()) should be (false)
  }

  "An Array(1, 4, 2, 3) sequence" should "be jolly jumper" in {
    val jmpr = JollyJumperSequenceDeterminer
    jmpr.isJollyJumperSeq(Array(1,4,2,3)) should be (true)
  }

  "An Array(1, 4, 2, -1, 6) sequence" should "be jolly jumper" in {
    val jmpr = JollyJumperSequenceDeterminer
    jmpr.isJollyJumperSeq(Array(1, 4, 2, -1, 6)) should be (false)
  }

  "An any array with one element" should "be considered as jolly jumper sequence" in {
    val jmpr = JollyJumperSequenceDeterminer
    jmpr.isJollyJumperSeq(Array(50)) should be (true)
  }

  "An any Array(11, 7, 4, 2, 1, 6) with one element" should "be considered as jolly jumper sequence" in {
    val jmpr = JollyJumperSequenceDeterminer
    jmpr.isJollyJumperSeq(Array(11, 7, 4, 2, 1, 6)) should be (true)
  }


}
