package com.ctiliescu.scala.redis.impl

import com.redis.RedisClient
import io.circe.parser.decode
import io.circe.syntax._
import io.circe.{Decoder, Encoder}

class RedisService {
  val client = new RedisClient("localhost", 6379)

  def optimiseOp[T](elem: => T, args: Any*)(implicit en: Encoder[T], de: Decoder[T]): T = {
    val key: String = args

    getCachedValue(key, args).getOrElse(setCachedValue(key, elem, args))
  }

  private def getCachedValue[T](key: String, args: Any*)(implicit en: Decoder[T]): Option[T] = {
    client.get(key).flatMap(e => toObject(e))
  }

  private def setCachedValue[T](key: String, obj: T, args: Any*)(implicit de: Encoder[T]): T = {
    val value = obj.asJson.noSpaces
    client.set(key, value)
    obj
  }

  private def toObject[T](s: String)(implicit en: Decoder[T]): Option[T] = {
    decode[T](s) match {
      case Right(e) => Some(e)
      case Left(e)  => None
    }
  }

  private implicit def composeKey(args: Seq[Any]): String = args.mkString(":")
}
