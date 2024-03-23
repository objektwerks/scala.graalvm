enablePlugins(GraalVMNativeImagePlugin)

name := "scala.graalvm"
organization := "objektwerks"
version := "0.2-SNAPSHOT"
scalaVersion := "3.4.1-RC2"
libraryDependencies ++= {
  val pekkoVersion = "1.0.3-M1"
  val pekkoHttpVersion = "1.0.1"
  Seq(
    "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
    "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
    "org.apache.pekko" %% "pekko-http" % pekkoHttpVersion,
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.5.3",
    "org.apache.pekko" %% "pekko-testkit" % pekkoVersion % Test,
    "org.apache.pekko" %% "pekko-http-testkit" % pekkoHttpVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.18" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
