package basics

import org.apache.spark.sql.SparkSession

case class person(Person:String,Age:Integer)


object datasaetsbasic extends App {
  
  val spark1=SparkSession.builder()
  .appName("Creating basic datasets")
  .master("hive")
  .getOrCreate()  
  
 import spark1.implicits._
 
  val df=spark1.read 
  .option("header",true)
  .option("inferSchema",true)
  .csv("src/test/resources/person.csv")
  .as[person]
  
  df.show()
  df.printSchema()
  
  
  val df1=df.filter(l=>l.Age>=22)
  
  df1.show()
  
  
  val df2=df.where(df("Age")>=22)
  //.where("Age>=22")
  
  
  df2.show()
  
  val select=df.select("Age")  //result will nbe df when we select
  
  select.show()  //for making as data sets create another case class
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
      
}