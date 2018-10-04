
name := "Music"

version := "0.1"

resolvers += Resolver.jcenterRepo
resolvers += Resolver.DefaultMavenRepository



libraryDependencies ++= Seq(
  //JDA
  "net.dv8tion" % "JDA" % "3.6.0_373",
  // Logger
  "org.apache.logging.log4j" % "log4j-core" % "2.11.1",
  // fucking impls
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.11.1",
  // fucking logging
  "org.apache.logging.log4j" % "log4j-api" % "2.11.1",
  // Lavaplayer
  "com.sedmelluq" % "lavaplayer" % "1.3.7",
  // JDA-NAS
  "com.sedmelluq" % "jda-nas" % "1.0.6",
  // Json 4 java
  "org.json4s" %% "json4s-native" % "3.6.0-M2",
  // HTTPS REQS
  "com.squareup.okhttp3" % "okhttp" % "3.11.0",
  // KIBANA STATS
  "com.sksamuel.elastic4s" %% "elastic4s-http" % "6.3.3",
)