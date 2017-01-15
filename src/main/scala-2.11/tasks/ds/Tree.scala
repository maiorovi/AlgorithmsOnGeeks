package tasks.ds

trait Tree[A] {

}

case class Node[A](left: Tree[A], right:Tree[A], value:A) extends Tree[A]

case class Leaf[A](value: A) extends Tree[A]