name := """backend"""
organization := "ch.gvbchallenge"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += javaJdbc
libraryDependencies += guice
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += filters
libraryDependencies += "joda-time" % "joda-time" % "2.10"
libraryDependencies += "com.fasterxml.jackson" % "jackson-base" % "2.9.6"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.6"