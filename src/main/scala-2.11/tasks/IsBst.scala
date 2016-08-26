package tasks

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

trait Tree[+A]

case class Node[A](value:A, left:Tree[A], right:Tree[A]) extends Tree[A]
case class Leaf[A](value:A) extends Tree[A]