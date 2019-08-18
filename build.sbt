name := "ScalaPractice"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.kafka" %% "kafka" % "1.0.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.2.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.2.0"

libraryDependencies += "org.apache.hbase" % "hbase-client" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-server" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-common" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase-hadoop2-compat" % "1.2.0"
libraryDependencies += "org.apache.hbase" % "hbase" % "1.2.0" pomOnly()

libraryDependencies += "org.json" % "json" % "20090211"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
libraryDependencies += "joda-time" % "joda-time" % "2.9.9"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.11.0"

libraryDependencies ++= Seq(
"org.scala-lang" % "scala-library" % "2.11.8",
"org.scala-lang" % "scala-reflect" % "2.11.8",
"org.scala-lang" % "scala-compiler" % "2.11.8"
)

libraryDependencies += "org.fluttercode.datafactory" % "datafactory" % "0.8"