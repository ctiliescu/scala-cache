package com.ctiliescu.scala.redis.impl

import io.circe.parser.decode
import io.circe.syntax._
import io.circe.{Decoder, Encoder}

class RedisService {
  def optimiseOp[T](elem: => T, args: Any*)(implicit en: Encoder[T], de: Decoder[T]): T = {
    val key: String = args

    getCachedValue(key, args) match {
      case Some(e) => e
      case None => setCachedValue(key, elem, args)
    }
  }

  private def getCachedValue[T](key: String, args: Any*)(implicit en: Decoder[T]): Option[T] = {
    // TODO - add implementation with real redis client
    MockedRedis.m.get(key).flatMap(toObject)
  }

  private def setCachedValue[T](key: String, obj: T, args: Any*)(implicit de: Encoder[T]): T = {
    val value = obj.asJson.noSpaces
    MockedRedis.m.put(key, value)
    obj
  }

  private def toObject[T](s: String)(implicit en: Decoder[T]): Option[T] = {
    decode[T](s) match {
      case Right(e) => Some(e)
      case Left(e) => None
    }
  }

  private implicit def composeKey(args: Seq[Any]): String = args.mkString(":")
}
