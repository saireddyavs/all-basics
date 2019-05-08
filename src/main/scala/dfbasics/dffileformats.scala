package dfbasics

import org.apache.spark.sql.SparkSession


//spark suppourts csv,json,orc,parquet by spark1X

//1X suppourts json,orc,parquet

object dffileformats {
  def main(args:Array[String]){
    val spark=SparkSession.builder()
    .appName("df file formats")
    .master("local")
    .getOrCreate()
    
    val df=spark.read
    .option("multiLine",true)
    .json("src/test/resources/example_1.json")
    
    df.printSchema()
    df.show()
   println("count:"+df.count())
   
   
    val orcdf=spark.read
    .option("multiLine",true)
    .orc("src/test/resources/12.orc")
    orcdf.printSchema()
    orcdf.show()
   println("count:"+orcdf.count())
   
   
   
   val paradf=spark.read
    .option("multiLine",true)
    .parquet("src/test/resources/userdata1.parquet")
    paradf.printSchema()
    paradf.show()
   println("count:"+paradf.count())
   
   
   val avrodf=spark.read
   .format("com.databrics.spark.avro")                        //spark wont suppourt so we are loadig
    .option("multiLine",true)  //we are adding avro dependencies
    .load("src/test/resources/twitter.avro")
    avrodf.printSchema()
    avrodf.show()
   println("count:"+avrodf.count())
   
   
   
  }
}