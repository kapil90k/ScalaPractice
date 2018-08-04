# Sep-2017
These small codes are the POC's which I am doing for learning purpose.

ExplodeDemo.scala:  Interview question in Mindtree 2017(Written exam 10 marks question). This code is reading one source file, creating schema and 
with that schema it creating the dataframe. One column of that schema is of type Array[String]. This code is exploding that Array[String] column
and creating multiple rows. Its using Dataframe explode() api

FlatMapDemo.scala:  Same thing as ExplodeDemo.scala usecase. But it is being implemented by rdd's flatMap method.

Creating Schema using StructType api
val schema=new StructType()
    .add("ID",IntegerType)
    .add("Name",ArrayType(StringType))
    .add("City",StringType)
    .add("State",StringType)
