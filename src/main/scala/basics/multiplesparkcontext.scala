package basics

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession


object multiplesparkcontext {
   def main(Args:Array[String]){
    /*
     val spark=new SparkConf()
     .set("spark.driver.allowMultipleContext","true")
     .setMaster("local")
     .setAppName("creating multiple contexts in one ")
     
     val sc=new SparkContext(spark)
     val sc1=new SparkContext(spark)
     
   
     val rdd=sc.parallelize(Array(1,2,3,4))
     
     val rdd=sc1.parallelize(Array(5,6,7,8,9))
     
     
     rdd.collect()
     
     rdd1.collect()
     
     */  //we can do multiple in 1X
     
     val spark=SparkSession.builder()
     .master("local")
     .appName("Creating multiple spark seesions")
     .getOrCreate()
     
     val spark1=SparkSession.builder()
     .master("local")
     .appName("Creating multiple spark seesions")
     .getOrCreate()
     
     
     val rdd=spark.sparkContext.parallelize(Array(1,2,3,4))
     
     val rdd1=spark1.sparkContext.parallelize(Array(5,6,7,8,9))
     
     rdd.collect().foreach(println)
     
     rdd1.collect().foreach(println)
     
     
     
     
       
   }
   
}