package pq

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class UnsortedArrayBasedPriorityQueueTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Priority Queue" should "return max from priority queue" in {
    val pq = setUpPriorityQueue()

    pq.max() should be(3)
  }

  "priority queue" should "return max and delete it" in {
    val pq = setUpPriorityQueue()

    pq.delMax() should be (3)
    pq.max() shouldNot be (3)
    pq.max() should be (2)
  }

  "priority queue" should "return its size" in {
    val pq = setUpPriorityQueue()

    pq.size() should be (3)
  }


  private def setUpPriorityQueue():PriorityQueue[Int] = {
    val pq = new UnsortedArrayBasedPriorityQueue[Int]()

    pq.insert(1)
    pq.insert(2)
    pq.insert(3)

    pq
  }


}
