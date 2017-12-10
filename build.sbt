name := "spark-world"

version := "1.0"

scalaVersion := "2.11.8"

val localDep = RootProject(file("/Users/sesadasivam/Documents/Sendil/Work/Research/Projects/spark-world"))

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
retrieveManaged := true
libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.2.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.2.0",
  "org.apache.hadoop" % "hadoop-client" % "2.7.2"

)

// https://mvnrepository.com/artifact/org.apache.tika/tika-core
libraryDependencies += "org.apache.tika" % "tika-core" % "1.16"
// https://mvnrepository.com/artifact/org.apache.tika/tika-parsers
libraryDependencies += "org.apache.tika" % "tika-parsers" % "1.16"


    