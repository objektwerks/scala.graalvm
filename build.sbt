enablePlugins(GraalVMNativeImagePlugin)

name := "scala.graalvm"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.12"
libraryDependencies ++= {
  val akkaVersion = "2.6.20" // Don't upgrade due to BUSL 1.1!
  val akkaHttpVersion = "10.2.10" // Don't upgrade due to BUSL 1.1!
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe" % "config" % "1.4.2",
    "ch.qos.logback" % "logback-classic" % "1.4.11",
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.16" % Test
  )
}
