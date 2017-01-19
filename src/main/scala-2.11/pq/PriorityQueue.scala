package pq

trait PriorityQueue[T] {
  def delMax():T
  def insert(elem: T): Unit
  def size():Int
  def max():T
}