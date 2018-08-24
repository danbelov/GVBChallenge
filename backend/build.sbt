name := """backend"""
organization := "ch.gvbchallenge"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
