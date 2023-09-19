Scala Graalvm
-------------
>Akka-Http server built and deployed to Graalvm.

Install
-------
>See: https://www.graalvm.org/docs/getting-started/

Test
----
1. sbt clean test

Run
---
1. sbt run
2. curl http://localhost:7979/now

Package
-------
1. sbt 'show graalvm-native-image:packageBin'

Execute
-------
1. ./target/graalvm-native-image/scala.graalvm
2. curl http://localhost:7979/now

Resources
---------
1. [GraalVM](https://www.graalvm.org/docs/introduction/)
2. [Sbt Packager](https://www.scala-sbt.org/sbt-native-packager/formats/graalvm-native-image.html)
