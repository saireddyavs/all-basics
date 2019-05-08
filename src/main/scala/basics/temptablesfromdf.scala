package basics

import org.apache.spark.sql.SparkSession

object temptablesfromdf {
  def main(args:Array[String]){
    val spark=SparkSession.builder()
    .appName("Creating temporary tables from df")
    .master("local")
    .getOrCreate()
    
    val df=spark.read.csv("src/test/resources/housingdata.csv")
    
    df.registerTempTable("housingdata") //1X way
    
    val df1=spark.sql("select * from housingdata ")
    df1.show()
    
    
    //2X Way
    
    df.createTempView("house")  //same as registerteamptable in 1X
    
    
    val df2=spark.sql("select _c1 from house")
    
    df2.show()
    
    df2.createOrReplaceTempView("house")  //it will replace if same name exits
    
    
    spark.sql("select _c1 from house").show()
    
    
    
    
    
    
    
    
    
    
    
    
  }
}