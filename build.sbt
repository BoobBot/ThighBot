
name := "ThighBot"

version := "1.0.0"

resolvers += Resolver.jcenterRepo
resolvers += Resolver.DefaultMavenRepository



libraryDependencies ++= Seq(
  //JDA
  "net.dv8tion" % "JDA" % "4.0.0_46",
  // Logger
  "org.apache.logging.log4j" % "log4j-core" % "2.11.1",
  // fucking impls
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.11.1",
  // fucking logging
  "org.apache.logging.log4j" % "log4j-api" % "2.11.1",
  // Json 4 java
  "org.json" % "json" % "20190722",
  // HTTPS REQS
  "com.squareup.okhttp3" % "okhttp" % "3.11.0",
  // HTTP server
  "com.sparkjava" % "spark-core" % "2.8.0",
)