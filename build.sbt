name := "ScalaPractice"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"

libraryDependencies += "org.apache.hbase" % "hbase-client" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-server" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-common" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-hadoop2-compat" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase" % "1.2.0" pomOnly()

libraryDependencies ++= Seq(
"org.scala-lang" % "scala-library" % "2.11.8",
"org.scala-lang" % "scala-reflect" % "2.11.8",
"org.scala-lang" % "scala-compiler" % "2.11.8"
)