package dfbasics

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.Row

object with2X {
  def main(args:Array[String]){
    val spark =SparkSession.builder()
    .master("local")
    .appName("Creaing data frame with spark 2X")
    .getOrCreate()
    
    val rdd=spark.sparkContext.parallelize(Array("0","1","2","03","4","5"))
    
    
    val schema =StructType(
     
        StructField("Intgers as String",StringType,true):: Nil
    )
    
    val rowrdd=rdd.map(element=> Row(element))
    
    val df=spark.createDataFrame(rowrdd, schema)
    
    df.printSchema()
    
    df.show()
  }
}