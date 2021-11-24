import Dependencies._

name := "greeter"

ThisBuild / scalaVersion := "2.12.13"

ThisBuild / organization := "com.shivamkapoor"
ThisBuild / organizationName := "shivamkapoor"
ThisBuild / organizationHomepage := Some(url("http://shivamkapoor.com/"))

crossScalaVersions := Seq(scalaVersion.value, "2.11.12", "2.13.0")

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/iamsmkr/greeter"),
    "scm:git@github.com:iamsmkr/greeter.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "iamsmkr",
    name = "Shivam Kapoor",
    email = "mail@shivamkapoor.com",
    url = url("http://shivamkapoor.com")
  )
)

ThisBuild / description := "Greet API"
ThisBuild / licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT"))
ThisBuild / homepage := Some(url("https://github.com/iamsmkr/greeter"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

ThisBuild / publishMavenStyle := true

libraryDependencies ++= Seq(
  scalaTest,
  scalaCheck
)

(compile in Compile) := ((compile in Compile) dependsOn writeHooks).value
