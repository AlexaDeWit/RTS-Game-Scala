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
    val window = glfwCreateWindow(640, 480, "Simple example", NULL, NULL);
    if (window == NULL) {
      glfwTerminate();
      throw new RuntimeException("Failed to create the GLFW window");
    }
    val keyCallback:GLFWKeyCallback = new GLFWKeyCallback() {
      @Override
      override def invoke(window:Long, key:Int, scancode:Int, action:Int, mods:Int): Unit = {
        if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
          glfwSetWindowShouldClose(window, GLFW_TRUE);
        }
      }
    };
    glfwSetKeyCallback(window, keyCallback);
    glfwMakeContextCurrent(window);
    GL.createCapabilities();

    while (glfwWindowShouldClose(window) != GLFW_TRUE) {
      update( deltaTime )  
      draw()
      Thread.sleep(sleepTime)
    }

    glfwDestroyWindow(window);
    keyCallback.release();

    glfwTerminate();
    errorCallback.release();
  }

  var lastTime = java.lang.System.currentTimeMillis();
  def deltaTime(): Long = {
    val now = java.lang.System.currentTimeMillis();
    val dtime = now - lastTime
    lastTime = now
    dtime
  }
  def update(dtime: Long): Unit = {
      glfwPollEvents();
  }
  def draw(): Unit = {
  }
}
