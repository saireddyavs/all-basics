package basics

//for changinfg default schema

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.LongType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType

object imposingownschema {
  def main(args:Array[String]){
    val spark=SparkSession.builder()
    .appName("creating own schema")
    .master("local")
    .getOrCreate()
    
    val df=spark.read
    .option("header",true)
    .option("inferSchema",true)
    .csv("src/test/resources/housingdata.csv")
    
    df.printSchema()
    df.show()
    
    val schema=StructType(
        
        StructField("A",LongType,true)::
        StructField("b",LongType,true)::
        StructField("c",LongType,true)::
        StructField("d",IntegerType,true)::
        StructField("e",StringType,true)::
        StructField("f",LongType,true)::
        StructField("g",LongType,true)::
        StructField("h",LongType,true)::
        StructField("i",LongType,true)::
        StructField("j",LongType,true)::
        StructField("k",LongType,true)::
        StructField("l",LongType,true)::
        StructField("m",LongType,true)::
        StructField("n",LongType,true)::Nil
        
        
    )  
    
    val df1=spark.read
    .schema(schema)
    .csv("src/test/resources/housingdata.csv")
    
    
    df1.printSchema()
    df.show()
    
  }
}