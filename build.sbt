name := "TestBikes"

version := "0.1"

scalaVersion := "2.12.8"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0" //% "provided"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0" //% "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.3" //% "runtime"
// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test

