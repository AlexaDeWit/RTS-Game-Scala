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
 * https://github.com/SilverTiger/lwjgl3-tutorial/blob/master/src/silvertiger/tutorial/lwjgl/graphic/Window.java
 */
package alexadewit.rts_game.core

import org.lwjgl._
import system.MemoryUtil._
import glfw._
import glfw.GLFW._
import opengl._
import opengl.GL11._

class Window(width: Int, height: Int, title: String,val vsync: Boolean) {
  /*
   *
   * Constructor Section
   *
   */
  val keyCallback:GLFWKeyCallback = new GLFWKeyCallback() {
    @Override
    override def invoke(window:Long, key:Int, scancode:Int, action:Int, mods:Int): Unit = {
      if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
        glfwSetWindowShouldClose(window, GLFW_TRUE);
      }
    }
  }
  val capabilities = determineCapabilities()
  if(capabilities.OpenGL32){
    setOpenGl32Hints()
  }else if(capabilities.OpenGL21){
    setOpenGl21Hints()
  }else{
    throw new RuntimeException("OpenGL 3.2 not supported, you may need to update your video card.")
  }
  private val id: Long = glfwCreateWindow(width, height, title, NULL, NULL)
  glfwSetKeyCallback(id, keyCallback)
  glfwMakeContextCurrent(id)
  GL.createCapabilities()
  setVSync(vsync)

  /* 
   *
   * CLASS BODY
   *
   */

  def setVSync(vsync: Boolean): Unit = {
  /* Enable v-sync */
    if (vsync) {
      glfwSwapInterval(1)
    } else {
      glfwSwapInterval(0)
    }
  }

  def determineCapabilities(): GLCapabilities = {
    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
    val temp = glfwCreateWindow(1, 1, "", NULL, NULL)
    glfwMakeContextCurrent(temp)
    GL.createCapabilities()
    val caps = GL.getCapabilities()
    glfwDestroyWindow(temp)
    caps
  }

  def setOpenGl32Hints(): Unit = {
    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2)
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
    glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE)
  }

  def setOpenGl21Hints(): Unit = {
    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 2);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
  }

  def isClosing(): Boolean = glfwWindowShouldClose(id) == GLFW_TRUE
  def setTitle(title:String): Unit = glfwSetWindowTitle(id, title)
  def destroy(): Unit = {
    glfwDestroyWindow(id)
  }
}
