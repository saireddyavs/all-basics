package basics

import org.apache.spark.sql.SparkSession
case class house(_c0:Double,_c1:Double,_c2:Double,_c3:Double,_c4:Double)

object checkingperfomancedfvsds extends App {
   val spark1=SparkSession.builder()
  .appName("Creating basic datasets")
  .master("local")
  .getOrCreate()  
  
   import spark1.implicits._
 
 var startds:Long=0;
   var endds:Long=0;
   
   startds=System.currentTimeMillis()
   
 
  val ds=spark1.read
  //.option("header",true)
  .option("inferSchema",true)
  .csv("src/test/resources/house1.csv")
  .as[house]
  
   val ds1=ds.filter("_c1>0")
   
  println("Count after filtering::"+ds1.count())
  
  endds=System.currentTimeMillis()
  var startdf:Long=0;
   var enddf:Long=0;
   
   startdf=System.currentTimeMillis()
   
 
  val df=spark1.read
  //.option("header",true)
  .option("inferSchema",true)
  .csv("src/test/resources/house1.csv")
 
  
   val df1=df.filter("_c1>0")
   
  println("Count after filtering::"+df1.count())
  
  enddf=System.currentTimeMillis()

  
  
  
  
   
  
  println("Time taken for datasets:::"+(endds-startds)/1000.0)
  println("Time taken for dataframe::"+(enddf-startdf)/1000.0)
  
  

}