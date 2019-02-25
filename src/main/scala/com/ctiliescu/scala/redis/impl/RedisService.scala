package com.ctiliescu.scala.redis.impl

import com.ctiliescu.scala.redis.model.RedisConfig
import com.redis.{RedisClient, Seconds}
import io.circe.parser.decode
import io.circe.syntax._
import io.circe.{Decoder, Encoder}

class RedisService(conf: RedisConfig) {
  val client = new RedisClient(conf.host, conf.port)

  def optimiseOp[T](elem: => T, persist: Long, args: Any*)(implicit en: Encoder[T], de: Decoder[T]): T = {
    val key: String = args

    getCachedValue(key, args).getOrElse(setCachedValue(key, persist, elem))
  }

  private def getCachedValue[T](key: String, args: Any*)(implicit en: Decoder[T]): Option[T] = {
    client.get(key).flatMap(e => toObject(e))
  }

  private def setCachedValue[T](key: String, persist: Long, obj: T)(implicit de: Encoder[T]): T = {
    val value = obj.asJson.noSpaces
    client.set(key, value, onlyIfExists = false, Seconds(persist))
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
