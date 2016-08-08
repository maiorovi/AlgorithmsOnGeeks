package tasks.support

class IntMatrix(val row:Int, val col:Int) {
  private val container: Array[Array[Int]] = Array.ofDim(row, col)

  def this(initial: Array[Array[Int]]) {
    this(initial.length, initial(0).length)
    (0 until row).foreach( crow => (0 until col).foreach( col => container(crow)(col) = initial(crow)(col)))
  }

  def apply(row:Int, col:Int):Int = container(row)(col)

  def update(row:Int, col:Int, value:Int): Unit = container(row)(col) = value
}


object IntMatrix {
  def apply(row:Int, col:Int):IntMatrix = new IntMatrix(row, col)
}