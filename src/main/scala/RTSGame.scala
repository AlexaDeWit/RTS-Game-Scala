package alexadewit.rts_game

import alexadewit.rts_game.core._
import scala.annotation.tailrec
import org.lwjgl._
import system.MemoryUtil._
import glfw._
import opengl._
import glfw.GLFW._
import opengl.GL11._

object Game {

  def main( args: Array[String] ): Unit = {
    val errorCallback = GLFWErrorCallback.createPrint(System.err)
    glfwSetErrorCallback(errorCallback)

    if (glfwInit() != GLFW_TRUE) {
      throw new IllegalStateException("Unable to initialize GLFW")
    }
    val window = new Window(640,480,"Hi!", true)
    val timer = new Timer()
    gameLoop(window, timer)

    window.destroy()

    glfwTerminate();
    errorCallback.release();
  }

  def gameLoop(window: Window, timer: Timer):Unit = {
    val targetFps = 60
    val targetUps = 60
    val targetUpdateDelta = 1.0f / targetUps //time an update is menat to take

    @tailrec
    def run(delta: Float, accumulator: Float): Unit = {
      input()

      @tailrec
      def runUpdates(accumulator: Float) {
        if( accumulator >= targetUpdateDelta ){
          update()
          timer.incrementUpsCount()
          runUpdates( accumulator - targetUpdateDelta )
        }
      }
      runUpdates( accumulator )

      val alpha = accumulator / targetUpdateDelta
      render(alpha)
      timer.incrementFpsCount()

      window.update()

      if(!window.isVSyncEnabled()) {
        sync(targetFps)
      }
      //Spin the recusive "loop"
      if( isRunning() && !window.isClosing() ){
        val nextDelta = timer.getLastDelta()
        run(nextDelta, accumulator + nextDelta )
      }
    }
    val delta = timer.getLastDelta()
    run(delta, delta)
  }

  def isRunning(): Boolean = {
    true
  }
  def update(): Unit = {
  }
  def input(): Unit = {
    glfwPollEvents()
  }
  def render(alpha: Float): Unit = {
  }

  def sync(targetFps: Int): Unit = {
    //sanity
    if( targetFps > 0 ){
      val sleepTime = 1000 / targetFps
      try{
        Thread.sleep(sleepTime)
      }
      catch{
        //do nothing for now
        case e: InterruptedException => Unit
      }
    }
  }
}
