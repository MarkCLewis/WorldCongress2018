fork := true

scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .settings(
    name         := "ScalaPlotPerformanceTesting",
    organization := "edu.trinity",
    crossScalaVersions := Seq("2.11.8"),  // Because Vegas-viz only does 2.11
    scalacOptions := Seq("-unchecked", "-deprecation"),
    version      := "0.1.0-SNAPSHOT",
//    libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value, 
//    libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value, 
//    libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value,
//    libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.102-R11",
//    libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4",
//    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test",

		libraryDependencies += "edu.trinity" %% "swiftvis2" % "0.1.0-SNAPSHOT",
		libraryDependencies += "org.vegas-viz" %% "vegas" % "0.3.11",
		libraryDependencies += "io.github.pityka" %% "nspl-awt" % "0.0.19",
		libraryDependencies += "org.scalanlp" %% "breeze-viz" % "0.13.2"

  )

