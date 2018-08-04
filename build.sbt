name := "ScalaPractice"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.SparkPrac" %% "SparkPrac-core" % "2.2.0"
libraryDependencies += "org.apache.SparkPrac" %% "SparkPrac-sql" % "2.2.0"

libraryDependencies += "org.apache.hbase" % "hbase-client" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-server" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-common" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-hadoop2-compat" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase" % "1.2.0" pomOnly()

libraryDependencies ++= Seq(
"org.ScalaPrac-lang" % "ScalaPrac-library" % "2.11.8",
"org.ScalaPrac-lang" % "ScalaPrac-reflect" % "2.11.8",
"org.ScalaPrac-lang" % "ScalaPrac-compiler" % "2.11.8"
)