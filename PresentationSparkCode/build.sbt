fork := true

scalaVersion := "2.11.12"

lazy val root = (project in file("."))
  .settings(
    name         := "SwiftVis2SparkDemos",
    organization := "edu.trinity",
    crossScalaVersions := Seq("2.11.12"),
    scalacOptions := Seq("-unchecked", "-deprecation"),
    version      := "0.1.0-SNAPSHOT",

		libraryDependencies += "edu.trinity" %% "swiftvis2" % "0.1.0-SNAPSHOT",
		libraryDependencies += "edu.trinity" %% "swiftvis2spark" % "0.1.0-SNAPSHOT",
		libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.1",
		libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.1",
		libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.3.1",
		libraryDependencies += "org.apache.spark" %% "spark-graphx" % "2.3.1"
  )

