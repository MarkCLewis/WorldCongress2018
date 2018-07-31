fork := true

scalaVersion := "2.12.6"

lazy val root = (project in file("."))
  .settings(
    name         := "SwiftVis2Demos",
    organization := "edu.trinity",
    crossScalaVersions := Seq("2.12.6"),
    scalacOptions := Seq("-unchecked", "-deprecation"),
    version      := "0.1.0-SNAPSHOT",

		libraryDependencies += "edu.trinity" %% "swiftvis2" % "0.1.0-SNAPSHOT",

  )

