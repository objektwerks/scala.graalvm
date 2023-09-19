Scala Graalvm
-------------
>Pekko-Http server built and deployed to Graalvm using Scala 3.

Install
-------
>See: https://www.graalvm.org/docs/getting-started/

>Example install on MacOs-M1:
1. tar -xzf graalvm-jdk-21_macos-aarch64_bin
2. sudo mv graalvm-jdk-21+35.1 /Library/Java/JavaVirtualMachines
3. sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-jdk-21+35.1

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