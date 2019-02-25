package com.ctiliescu.scala.redis

import com.ctiliescu.scala.redis.model.RedisConfig

// TODO - delete this class
object Bootstrap extends App with CacheComposer {
  override val conf = RedisConfig("localhost", 6379)

  // used only for tests
  def test(c: Int, b: String): String = {
    println(b + "  --  " + c)
    Thread.sleep(5000)
    "s"
  }

  def test2(a: Int, b: String, c: String, d: String): Int = {
    println(b + "  --  " + c)
    3
  }

  println(cache(test, 3, ""))
  println(cache(test, 3, ""))
  println(cache(test, 3, ""))
  val y: Int = cache(test2, 3, "2", "", "a")
}
