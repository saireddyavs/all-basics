package basics

import org.apache.spark.sql.SparkSession

object know {
  def main(args:Array[String]){
    val spark=SparkSession.builder()
    .appName("Konwing gcp")
    .getOrCreate()
    
    val rdd=spark.sparkContext.parallelize(Array(0,1,2,3,4,5))
    
    rdd.collect().foreach(println)
    
    spark.conf.getAll.foreach(println)
    
  }
}