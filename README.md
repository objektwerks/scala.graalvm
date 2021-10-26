Scala Graalvm
-------------
>Akka Http server built and deployed to Graalvm.

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

Resources
---------
1. Gaalvm: https://www.graalvm.org/docs/introduction/
2. Packager: https://www.scala-sbt.org/sbt-native-packager/formats/graalvm-native-image.html