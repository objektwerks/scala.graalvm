enablePlugins(GraalVMNativeImagePlugin)

name := "scala.graalvm"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.12"
libraryDependencies ++= {
  val pekkoVersion = "1.0.1"
  val pekkoHttpVersion = "1.0.0"
  Seq(
    "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
    "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
    "org.apache.pekko" %% "pekko-http" % pekkoHttpVersion,
    "com.typesafe" % "config" % "1.4.2",
    "ch.qos.logback" % "logback-classic" % "1.4.11",
    "org.apache.pekko" %% "pekko-testkit" % pekkoVersion % Test,
    "org.apache.pekko" %% "pekko-http-testkit" % pekkoHttpVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.16" % Test
  )
}