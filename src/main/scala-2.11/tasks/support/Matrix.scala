package tasks.support

/**
  * Created by egor on 8/8/16.
  */
class Matrix(val row:Int, val col:Int) {
  private val container: Array[Array[Int]] = Array.ofDim(row, col)

  def apply(row:Int, col:Int):Int = container(row)(col)

  def update(row:Int, col:Int, value:Int): Unit = container(row)(col) = value

}


object Matrix {
  def apply(row:Int, col:Int):Matrix = new Matrix(row, col)
}