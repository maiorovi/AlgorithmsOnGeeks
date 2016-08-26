package tasks

import scala.reflect.ClassTag

object IsBst extends App {

  def isBst(tree:Tree[Int]):Boolean = tree match {
    case Node(value, left, right) => if (value > max(left) && value < min(right)) isBst(left) && isBst(right) else false
    case Leaf(value) => true
  }

  private def max(tree:Tree[Int]):Int = comparison(tree, Math.max)

  private def min(tree:Tree[Int]):Int = comparison(tree, Math.min)

  private def comparison(tree:Tree[Int], f: (Int, Int) => Int ):Int = tree match {
    case Node(value, left, right) => f( value, f(comparison(left, f), comparison(right,f)))
    case Leaf(value) => value
  }


  val bst = Node(10, Node(6, Leaf(4), Leaf(7)),Node(15, Leaf(12), Leaf(16)) )
  val notBst = Node(10, Node(6, Leaf(4), Leaf(7)),Node(15, Leaf(12), Leaf(11)) )
//  val trieBst = Node(18, Node(5, Leaf(4), Leaf(3)), Node(12, Leaf(15), Leaf(11)))
//  println(max(notBst))
//  println(max(trieBst))
//  println(min(notBst))
//  println(min(trieBst))

  println(isBst(bst)) //true
  println(isBst(notBst)) // false

  val ex1 =  Node(3, Node(2, Leaf(1), Leaf(4)), Leaf(5))
  println(isBst(ex1)) // false
}

trait Tree[+A] {
  def toArray[B >: A](implicit m: ClassTag[B]):Array[B] = {
    val array = new Array[B](this.size)
    var pointer:Int = 0

    def loop(acc:Array[B], tree:Tree[B]):Array[B] =  tree match {
      case Node(value, left, right) => {
        loop(acc, left)
        acc(pointer) = value
        pointer = pointer + 1
        loop(acc, right)
      }
      case Leaf(value) => {
        acc(pointer) = value
        pointer = pointer + 1
        acc
      }
    }

    loop(array, this)
  }

  def size:Int = this match {
    case Node(value, left, right) => 1 + left.size + right.size
    case Leaf(value) => 1
  }
}

case class Node[A](value:A, left:Tree[A], right:Tree[A]) extends Tree[A]
case class Leaf[A](value:A) extends Tree[A]

object isBstUsingInOrderTraversal extends App {
  def isBst(tree:Tree[Int]):Boolean = {
    val array = tree.toArray
    var i = 0
    var result = true

    while(i < array.length - 1) {
      if (array(i) > array(i + 1)) {
          result = false
      }
      i = i + 1
    }

    result
  }


  val bst = Node(10, Node(6, Leaf(4), Leaf(7)),Node(15, Leaf(12), Leaf(16)) )
  val notBst = Node(10, Node(6, Leaf(4), Leaf(7)),Node(15, Leaf(12), Leaf(11)) )

  println(bst.size)
  println(bst.toArray.mkString(" "))

  println(isBst(bst)) // true
  println(isBst(notBst)) // false
  val ex1 =  Node(3, Node(2, Leaf(1), Leaf(4)), Leaf(5))
  println(isBst(ex1)) // false
}