import Dependencies._

name := "sonatype"

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.iamsmkr"
ThisBuild / scalaVersion := "2.12.14"

libraryDependencies ++= Seq(
  scalaTest,
  scalaCheck
)
