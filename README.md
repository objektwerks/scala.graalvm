Scala Graalvm
-------------
>Pekko-Http server built and deployed to JDK 21 Graalvm using Scala 3.

Install
-------
>See: https://www.graalvm.org/docs/getting-started/

>Example install on MacOs-M1:
1. tar -xzf graalvm-jdk-21_macos-aarch64_bin
2. sudo mv graalvm-jdk-21+35.1 /Library/Java/JavaVirtualMachines
3. sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-jdk-21+35.1
>Step 3 will fix this error: ***graalvm-jdk-21+35.1 is damanged and can't be opened.***

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