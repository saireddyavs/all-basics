package dfbasics

import org.apache.spark.sql.SparkSession

object creatinddfwithcsv2X {
  def main(args:Array[String]){
    val spark= SparkSession.builder()
    .appName("creating df with spark 2X")
    .master("local")
    .getOrCreate()
    
     val df=spark.read.csv("src/test/resources/housindata.csv")
    
    df.printSchema()
    
    df.show()
    
  }
}