name := "ScalaRoute"

version := "0.1"

scalaVersion := "2.11.8"

lazy val akkaVersion = "2.4.19"

val sprayVersion = "1.3.1"

resolvers ++= Seq(
  "Spray Repository" at "http://repo.spray.io/"
)


libraryDependencies ++= Seq(
  "org.scalesxml" % "scales-xml_2.9.1" % "0.3-RC7",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10" % Test,
  "io.spray" %% "spray-routing" % sprayVersion,
  "io.spray" %% "spray-can" % sprayVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10"
)

