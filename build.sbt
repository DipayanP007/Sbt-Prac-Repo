name := "sbt-prac"

val common = Seq(
version := "0.1",
scalaVersion := "2.13.6",
idePackagePrefix := Some("org.practice")
)
//resolvers += Resolver.url("sbt-scoverage", url("https://github.com/scoverage/sbt-scoverage/"))

lazy val rootProject = (project in file("."))
  .settings(common)
  .settings(
    publishArtifact := false
  ).aggregate(f_module,lib)

lazy val f_module = (project in file("first-module"))
  .settings(common)
  .settings(
    name := "first-module"
  ).dependsOn(lib)

lazy val lib = (project in file("my-lib"))
  .settings(common)
  .settings(
    name := "my-lib",
      // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
      libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.6.15",
    "com.h2database" % "h2" % "1.4.200" % Test,
    "com.typesafe.akka" %% "akka-stream" % "2.6.15")




)