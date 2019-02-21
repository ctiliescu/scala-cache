package com.ctiliescu.scala.redis.impl

class RedisService {
  private def getCachedValue[T](args: Any*): Option[T] = {
    val key: String = args
    // TODO - add implementation
    None
  }

  private def setCachedValue[T](obj: T, args: Any*) = {
    val key: String = args
    // TODO - add implementation
  }

  private implicit def composeKey(args: Seq[Any]): String = args.mkString(":")
}
