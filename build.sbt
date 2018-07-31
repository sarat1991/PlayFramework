name := """ProjectStudent"""
organization := "com.training"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice

// https://mvnrepository.com/artifact/org.reactivemongo/play2-reactivemongo
libraryDependencies += "org.mongodb" % "mongodb-driver" % "3.0.4"

libraryDependencies +=  "uk.co.panaxiom" %% "play-jongo" % "2.1.0-jongo1.3"

