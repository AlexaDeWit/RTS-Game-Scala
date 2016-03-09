package alexadewit.rts_game

class Timer(initialTime: Long) {
  def this() {
    this(java.lang.System.currentTimeMillis())
  }
  var lastTime = initialTime
  def getLastDelta() = {
    val curr = java.lang.System.currentTimeMillis()
    val delta = curr - lastTime
    lastTime = curr
    delta
  }
}
