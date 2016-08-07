package tasks

object BinarySearch {

  def search[T <% Ordered[T]](x:Array[T], v:T):Boolean = {
    def loop(b:Int, t:Int):Boolean = {
      val mid = (t - b)/ 2 + b

      if (x(mid) == v) {
        return true
      }

      if (t <= b) {
        return false
      }


      if (x(mid) > v) {
        loop(b,mid-1)
      } else {
        loop(mid+1, t)
      }


    }

    loop(0, x.length - 1)
  }
}
