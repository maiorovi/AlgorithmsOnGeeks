package pq

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

class UnsortedArrayBasedPriorityQueue[T <% Ordered[T]](implicit m: ClassTag[T]) extends PriorityQueue[T]{
  private var storage = new ArrayBuffer[T]()
  private var counter:Int = 0

  override def delMax(): T = {
      val maxValue: T = findMax()
      counter -= 1

      swap(storage.indexOf(maxValue), counter)
      storage.remove(counter)

      maxValue
  }

  private def findMax(): T = {
    storage.reduce((op1, op2) => max(op1, op2))
  }

  private def swap(ind1: Int, ind2: Int):Unit = {
    val tmp = storage(ind1)
    storage(ind1) = storage(ind2)
    storage(ind2) = tmp
  }

  private def max(op1:T, op2:T ):T = if (op1 <= op2) op2 else op1

  override def insert(elem: T): Unit = {
    storage += elem
    counter += 1
  }

  override def size(): Int = counter

  override def max(): T = findMax()
}
