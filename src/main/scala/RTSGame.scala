package alexadewit.rts_game
import alexadewit.rts_game.core._
import org.lwjgl._
import system.MemoryUtil._
import glfw._
import opengl._
import glfw.GLFW._
import opengl.GL11._

object Main {
  def main( args: Array[String] ): Unit = {
    val sleepTime = 1000L / 60L
    val errorCallback = GLFWErrorCallback.createPrint(System.err);
    glfwSetErrorCallback(errorCallback);

    if (glfwInit() != GLFW_TRUE) {
      throw new IllegalStateException("Unable to initialize GLFW");
    }
    val window = new Window(640,480,"Hi!", true)
    val timer = new Timer()

    while(!window.isClosing()) {
      val delta = timer.getLastDelta()
      update(delta)  
      draw(glfwGetCurrentContext())
      Thread.sleep(sleepTime)
    }
    window.destroy()

    glfwTerminate();
    errorCallback.release();
  }

  def update(dtime: Long): Unit = {
      glfwPollEvents()
  }
  def draw(context: Long): Unit = {
    glfwSwapBuffers(context)
  }
}
