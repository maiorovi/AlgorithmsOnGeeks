package tasks

object Traversals {

  def main(args: Array[String]) {
    val tree = Node("F", Node("B", Leaf("A"), Node("D", Leaf("C"), Leaf("E"))), Leaf("Q"))
    println(preOrderTraversal(tree).mkString(", "))
    println(inOrderTraversal(tree).mkString(", "))
    println(postOrderTraversal(tree).mkString(", "))
  }

  def preOrderTraversal[A](tree: Tree[A]): List[A] = {
    def loop[B](tree: Tree[B]): List[B] = tree match {
      case Node(value, left, right) => value::loop(left) ++: loop(right)
      case Leaf(value) => value::Nil;
    }

    loop(tree)
  }

  def inOrderTraversal[A](tree: Tree[A]): List[A] = {
    def loop[B](tree: Tree[B]): List[B] = tree match {
      case Node(value, left, right) => loop(left) ++: (value::loop(right))
      case Leaf(value) => value::Nil;
    }

    loop(tree)
  }

  def postOrderTraversal[A](tree: Tree[A]): List[A] = {
    def loop[B](tree: Tree[B]): List[B] = tree match {
      case Node(value, left, right) => loop(left) ++: loop(right) ++: List(value)
      case Leaf(value) => value::Nil;
    }

    loop(tree)
  }


}
