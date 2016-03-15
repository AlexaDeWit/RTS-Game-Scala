package alexadewit.rts_game
import alexadewit.rts_game.core._
import org.lwjgl._
import system.MemoryUtil._
import glfw._
import opengl._
import glfw.GLFW._
import opengl.GL11._

object Main {

  val targetFps = 60

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

  def gameLoop(window: Window, timer: Timer): Unit = {
    var accumulator = 0L
    var passes = 0
    while(!window.isClosing()) {
      val delta = timer.getLastDelta()
      accumulator = accumulator + delta
      passes = passes + 1

      update(delta)  
      timer.incrementUpsCount()

      draw(glfwGetCurrentContext())
      timer.incrementFpsCount()

      if(!window.isVSyncEnabled()) {
        sync(targetFps)
      }
    }

  }

  def update(dtime: Long): Unit = {
      glfwPollEvents()
  }
  def draw(context: Long): Unit = {
    glfwSwapBuffers(context)
  }

  def sync(targetFps: Int): Unit = {
  }
}
