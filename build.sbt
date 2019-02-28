name := "scala-cache"

organization := "io.github.ctiliescu"

version := "0.2"

scalaVersion := "2.12.8"

// circer libraries - used for serialization
val circeVersion = "0.11.0"
libraryDependencies ++= Seq("io.circe" %% "circe-core", "io.circe" %% "circe-generic", "io.circe" %% "circe-parser")
  .map(_ % circeVersion)

// redis integration
libraryDependencies ++= Seq("net.debasishg" %% "redisclient" % "3.9")

// enable the formatter on compile and running tests
scalafmtOnCompile in ThisBuild := true
scalafmtTestOnCompile in ThisBuild := true

// POM settings for Sonatype
homepage := Some(url("https://github.com/ctiliescu/scala-cache"))
scmInfo := Some(ScmInfo(url("https://github.com/ctiliescu/scala-cache"), "git@github.com:ctiliescu/scala-cache.git"))
developers := List(
  Developer("ctiliescu", "Cristian Iliescu", "ctiliescu@gmail.com", url("https://github.com/ctiliescu")))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
publishMavenStyle := true

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

publishMavenStyle := true
publishConfiguration := publishConfiguration.value.withOverwrite(true)
publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true)
