name := "World Congress Spark Project"
 
version := "1.0"

// At this time Spark doesn't yet support Scala 2.12 
scalaVersion := "2.11.12"

libraryDependencies += "edu.trinity" %% "swiftvis2" % "0.1.0-SNAPSHOT"
libraryDependencies += "edu.trinity" %% "swiftvis2spark" % "0.1.0-SNAPSHOT" 
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.1"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.3.1"
libraryDependencies += "org.apache.spark" %% "spark-graphx" % "2.3.1"
