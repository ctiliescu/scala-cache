# Scala cache library using Redis

### Key features of the library

### Usage

```scala
def func(arg1: String, arg2: String): String = {
  // Very long function
};

var result = cache(func, "v1", "v2")
```

### Requirements
* sbt   (get it at http://www.scala-sbt.org/)
* redis (get it at http://redis.io)
