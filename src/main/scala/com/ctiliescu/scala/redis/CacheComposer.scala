package com.ctiliescu.scala.redis

import com.ctiliescu.scala.redis.impl.RedisService
import io.circe.{Decoder, Encoder}

object CacheComposer {
  def cache[A, R](func: A => R, a: A)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a), a)
  }

  def cache[A, B, R](func: (A, B) => R, a: A, b: B)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b), a, b)
  }

  def cache[A, B, C, R](func: (A, B, C) => R, a: A, b: B, c: C)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c), a, b, c)
  }

  def cache[A, B, C, D, R](func: (A, B, C, D) => R, a: A, b: B, c: C, d: D)(implicit en: Encoder[R],
                                                                            de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c, d), a, b, c, d)
  }

  def cache[A, B, C, D, E, R](func: (A, B, C, D, E) => R, a: A, b: B, c: C, d: D, e: E)(implicit en: Encoder[R],
                                                                                        de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c, d, e), a, b, c, d, e)
  }

  def cache[A, B, C, D, F, G, R](func: (A, B, C, D, F, G) => R, a: A, b: B, c: C, d: D, e: F, f: G)(
      implicit en: Encoder[R],
      de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c, d, e, f), a, b, c, d, e, f)
  }

  def cache[A, B, C, D, F, G, H, R](func: (A, B, C, D, F, G, H) => R, a: A, b: B, c: C, d: D, e: F, f: G, h: H)(
      implicit en: Encoder[R],
      de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c, d, e, f, h), a, b, c, d, e, f, h)
  }

  def cache[A, B, C, D, F, G, H, I, R](func: (A, B, C, D, F, G, H, I) => R,
                                       a: A,
                                       b: B,
                                       c: C,
                                       d: D,
                                       e: F,
                                       f: G,
                                       h: H,
                                       i: I)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c, d, e, f, h, i), a, b, c, d, e, f, h, i)
  }

  def cache[A, B, C, D, F, G, H, I, J, R](func: (A, B, C, D, F, G, H, I, J) => R,
                                          a: A,
                                          b: B,
                                          c: C,
                                          d: D,
                                          e: F,
                                          f: G,
                                          h: H,
                                          i: I,
                                          j: J)(implicit en: Encoder[R], de: Decoder[R]): R = {
    new RedisService().optimiseOp(func(a, b, c, d, e, f, h, i, j), a, b, c, d, e, f, h, i, j)
  }
}
