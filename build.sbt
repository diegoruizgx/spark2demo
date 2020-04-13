name := "spark2demo"

version := "0.1"

//scalaVersion := "2.11.12"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq( "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "com.amazonaws" % "aws-java-sdk" % "1.2.1",
  "org.apache.hadoop" % "hadoop-aws" % "2.7.3",
  "org.apache.hadoop" % "hadoop-common" % "3.1.2" exclude("org.slf4j","slf4j-log4j12"))
