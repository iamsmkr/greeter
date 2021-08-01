import sbt._

object Dependencies {
  private lazy val scalaTestVersion = "3.2.9"
  private lazy val scalaCheckVersion = "3.2.9.0"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test
  lazy val scalaCheck = "org.scalatestplus" %% "scalacheck-1-15" % scalaCheckVersion % Test
}
