package com.ctiliescu.scala.redis.impl

class RedisService {
  def optimiseOp[T](elem: => T, args: Any*): T = {
    val key: String = args

    getCachedValue(key, args) match {
      case Some(e) => e
      case None =>
        val x = elem
        setCachedValue(key, x, args)
    }
  }

  private def getCachedValue[T](key: String, args: Any*): Option[T] = {
    println("get")
    // TODO - add implementation
    None
  }

  private def setCachedValue[T](key: String, obj: T, args: Any*): T = {
    println("post")
    obj
    // TODO - add implementation
  }

  private implicit def composeKey(args: Seq[Any]): String = args.mkString(":")
}
