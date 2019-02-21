package com.ctiliescu.scala.redis

import CacheComposer._

// TODO - delete this class
object Bootstrap extends App {
  // used only for tests
  def test(c: Int, b: String): String= {
    println(b  + "  --  " + c)
    "s"
  }
  def test2(a: Int, b: String, c: String, d: String): Int= {
    println(b  + "  --  " + c)
    3
  }

  val x: String = cache(test, 3, "")
  val y: Int = cache(test2, 3, "", "", "")
}
