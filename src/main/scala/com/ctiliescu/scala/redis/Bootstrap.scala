package com.ctiliescu.scala.redis

import CacheComposer._

object Bootstrap extends App {
  // used only for tests
  def test(c: Int, b: String): Unit= println(b  + "  --  " + c)

  cache(test, 1,"3")
}
