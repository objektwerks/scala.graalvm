Scala Graalvm
-------------
>Pekko-Http server built and deployed to JDK 24 GraalVM using Scala 3.

Install
-------
>[GraalVM Getting Started](https://www.graalvm.org/docs/getting-started/)

>Install:
1. tar -xzf graalvm-jdk-24_macos-aarch64_bin
2. sudo mv graalvm-jdk-24+36.1 /Library/Java/JavaVirtualMachines
3. sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-jdk-24+36.1
>Step 3 fixes this error: ***graalvm-jdk-24+36.1 is damaged and can't be opened.***

Test
----
1. sbt clean test

Run
---
1. sbt run
2. curl http://localhost:7979/now

Package
-------
>Takes around 60 seconds. **Note:** Only 1 main class is allowed in an sbt-native-packager project.
1. sbt 'show graalvm-native-image:packageBin'

Execute
-------
1. ./target/graalvm-native-image/scala.graalvm
2. curl http://localhost:7979/now

Resources
---------
* [GraalVM](https://www.graalvm.org/docs/introduction/)
* [Sbt Packager](https://www.scala-sbt.org/sbt-native-packager/formats/graalvm-native-image.html)
