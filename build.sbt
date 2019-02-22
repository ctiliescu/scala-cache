name := "scala-cache"

version := "0.1"

scalaVersion := "2.12.8"

// circer libraries - used for serialization
val circeVersion = "0.11.0"
libraryDependencies ++= Seq("io.circe" %% "circe-core", "io.circe" %% "circe-generic", "io.circe" %% "circe-parser")
  .map(_ % circeVersion)