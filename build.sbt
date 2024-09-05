enablePlugins(GraalVMNativeImagePlugin)

name := "scala.graalvm"
organization := "objektwerks"
version := "0.2-SNAPSHOT"
scalaVersion := "3.5.1-RC2"
libraryDependencies ++= {
  val pekkoVersion = "1.1.0"
  val pekkoHttpVersion = "1.0.1"
  Seq(
    "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
    "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
    "org.apache.pekko" %% "pekko-http" % pekkoHttpVersion,
    "com.typesafe" % "config" % "1.4.3",
    "ch.qos.logback" % "logback-classic" % "1.5.7",
    "org.apache.pekko" %% "pekko-testkit" % pekkoVersion % Test,
    "org.apache.pekko" %% "pekko-http-testkit" % pekkoHttpVersion % Test,
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
