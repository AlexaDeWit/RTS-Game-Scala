/*
 * The MIT License (MIT)
 *
 * Copyright © 2014, Heiko Brumme
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/*
 * Highly based on an example written by Heiko Brumme, sufficiently so that I feel
 * credit should go to Heiko and that the license should be preserved.
 * At the time of authorship, Heiko's work was located here:
 * https://github.com/SilverTiger/lwjgl3-tutorial/blob/master/src/silvertiger/tutorial/lwjgl/core/Timer.java
 */

package alexadewit.rts_game
import org.lwjgl.glfw.GLFW._

class Timer(initialTime: Long) {
  def this() {
    this(java.lang.System.currentTimeMillis())
  }

  private var lastTime = initialTime
  private var timeAccummulator = 0L
  private var fps = 0
  private var ups = 0
  private var fpsCount = 0
  private var upsCount = 0

  def getLastDelta() = {
    val curr = java.lang.System.currentTimeMillis()
    val delta = curr - lastTime
    lastTime = curr
    timeAccummulator = timeAccummulator + delta
    update()
    delta
  }
  def elapsedTime() = glfwGetTime()
  
  private def update(): Unit = {
    if( timeAccummulator > 1000 ){
      ups = upsCount
      upsCount = 0
      fps = fpsCount
      fpsCount = 0
      timeAccummulator = timeAccummulator - 1000
    }
  }

  def incrementUpsCount: Unit = {
    upsCount = upsCount + 1
  }
  def incrementFpsCount: Unit = {
    fpsCount = fpsCount + 1
  }

  def getFps = if(fps > 0 ) fps else fpsCount
  def getUps = if(ups > 0 ) ups else upsCount

}
