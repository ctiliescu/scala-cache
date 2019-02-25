package com.ctiliescu.scala.redis

import com.ctiliescu.scala.redis.impl.RedisService
import com.ctiliescu.scala.redis.model.RedisConfig
import io.circe.{Decoder, Encoder}

trait CacheComposer {
  val conf: RedisConfig
  val defaultTime: Long = 360

  def cache[A, R](func: A => R, a: A)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a), defaultTime, a)
  }

  def cache[A, B, R](func: (A, B) => R, a: A, b: B)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b), defaultTime, a, b)
  }

  def cache[A, B, C, R](func: (A, B, C) => R, a: A, b: B, c: C)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c), defaultTime, a, b, c)
  }

  def cache[A, B, C, D, R](func: (A, B, C, D) => R, a: A, b: B, c: C, d: D)(implicit en: Encoder[R],
                                                                            de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c, d), defaultTime, a, b, c, d)
  }

  def cache[A, B, C, D, E, R](func: (A, B, C, D, E) => R, a: A, b: B, c: C, d: D, e: E)(implicit en: Encoder[R],
                                                                                        de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c, d, e), defaultTime, a, b, c, d, e)
  }

  def cache[A, B, C, D, E, F, R](func: (A, B, C, D, E, F) => R, a: A, b: B, c: C, d: D, e: E, f: F)(
      implicit en: Encoder[R],
      de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c, d, e, f), defaultTime, a, b, c, d, e, f)
  }

  def cache[A, B, C, D, E, F, G, R](func: (A, B, C, D, E, F, G) => R, a: A, b: B, c: C, d: D, e: E, f: F, g: G)(
      implicit en: Encoder[R],
      de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c, d, e, f, g), defaultTime, a, b, c, d, e, f, g)
  }

  def cache[A, B, C, D, E, F, G, H, R](func: (A, B, C, D, E, F, G, H) => R,
                                       a: A,
                                       b: B,
                                       c: C,
                                       d: D,
                                       e: E,
                                       f: F,
                                       g: G,
                                       h: H)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c, d, e, f, g, h), defaultTime, a, b, c, d, e, f, g, h)
  }

  def cache[A, B, C, D, E, F, G, H, I, R](func: (A, B, C, D, E, F, G, H, I) => R,
                                          a: A,
                                          b: B,
                                          c: C,
                                          d: D,
                                          e: E,
                                          f: F,
                                          g: G,
                                          h: H,
                                          i: I)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService(conf).optimiseOp(func(a, b, c, d, e, f, g, h, i), defaultTime, a, b, c, d, e, f, g, h, i)
  }
}
