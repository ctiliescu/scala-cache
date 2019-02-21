package com.ctiliescu.scala.redis

object CacheComposer {
  def cache[A, R](func: A => R, a: A): R = {
    func(a)
  }

  def cache[A, B, R](func: (A, B) => R, a: A, b: B): R = {
    func(a, b)
  }

  def cache[A, B, C, R](func: (A, B, C) => R, a: A, b: B, c: C): R = {
    func(a, b, c)
  }

  def cache[A, B, C, D, R](func: (A, B, C, D) => R, a: A, b: B, c: C, d: D): R = {
    func(a, b, c, d)
  }

  def cache[A, B, C, D, E, R](func: (A, B, C, D, E) => R, a: A, b: B, c: C, d: D, e: E): R = {
    func(a, b, c, d, e)
  }

  def cache[A, B, C, D, F, G, R](func: (A, B, C, D, F, G) => R, a: A, b: B, c: C, d: D, e: F, f: G): R = {
    func(a, b, c, d, e, f)
  }

  implicit def conv[T](elem: T): String = elem.toString
}
