# Scala cache library using Redis

### Key features of the library
____

### Instalation
____
The artifacts are published to Maven Central.
```scala
libraryDependencies ++= Seq(
  "io.github.ctiliescu" % "scala-cache_2.12" % "0.1",
  ...
)
```

### Usage
____
To be able to cache the function results, the CacheCompuser should be mixed and defined 
```scala
class Test extends CacheComposer {
  override val conf = RedisConfig("localhost", 6379)

  def func(arg1: String, arg2: String): String = {
    println("Start execute complex function")
    // Very time consuming function
    s"$arg1:$arg2"
  };

  var r1 = cache(func, "v1", "v2")
  pritnln(r1)
  var r2 = cache(func, "v1", "v2")
  pritnln(r2)
  var r3 = cache(func, "v1", "v3")
  pritnln(r3)
  var r4 = cache(func, "v1", "v2")
  pritnln(r4)
}
```
When the Test class is executed the output will be:
```linux
  scala> "execute_test_class"
  Start execute complex function
  v1:v2
  v1:v2
  Start execute complex function
  v1:v3
  v1:v2
```

### Requirements
____
* sbt   (get it at http://www.scala-sbt.org/)
* redis (get it at http://redis.io)
