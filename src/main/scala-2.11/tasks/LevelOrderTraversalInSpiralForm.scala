package tasks

import java.util

object LevelOrderTraversalInSpiralForm extends App {

  def printTree(tree:Tree[Int]):Unit = {
    val evenStack = new util.Stack[Tree[Int]]()
    val oddStack = new util.Stack[Tree[Int]]()
    var level = 1

    oddStack.push(tree)

    while (!evenStack.isEmpty || !oddStack.isEmpty) {
      if (level % 2 == 0) {
        while (!evenStack.isEmpty) {
          val tmp = evenStack.pop()
          tmp match {
            case Node(value, left, right) => {
              print(s"${value} ")
              oddStack.push(left)
              oddStack.push(right)
            }
            case Leaf(value) => print(s"${value} ")
          }

        }

        level = level + 1
      } else {

        while (!oddStack.isEmpty) {
          val tmp = oddStack.pop()
          tmp match {
            case Node(value, left, right) => {
              print(s"${value} ")
              evenStack.push(right)
              evenStack.push(left)
            }
            case Leaf(value) => print(s"${value} ")
          }
          level = level + 1
        }
      }

    }
  }

  val tree = Node(1, Node(2, Leaf(7), Leaf(6)), Node(3, Leaf(5), Leaf(4)))

  printTree(tree)

}