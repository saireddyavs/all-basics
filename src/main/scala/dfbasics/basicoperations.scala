package dfbasics

import org.apache.spark.sql.SparkSession

object basicoperations {
  def main(Args:Array[String]){
    val spark=SparkSession.builder()
    .master("local")
    .appName("basic df operations")
    .getOrCreate()
      
    
    val df=spark.read.csv("src/test/resources/housingdata.csv")
    
    df.printSchema()
    
    val dfschema=df.schema   //it will return StructType
    
    println("schemaaa:"+dfschema)
    
    
    val colnames=df.columns
    
    
    println("columns"+colnames)  //Array Type
    
    
    println(colnames.mkString(","))  //toshow like array
    
    val desc=df.describe("_c1")
    
    desc.show()
    
    val coltypes=df.dtypes
    println("col names and data types")
    println(coltypes)
    
    coltypes.foreach(println)
     
    
    
    df.head(5).foreach(println)
    
    df.show(5)
    
    
    val df1=df.select("_c1","_c3" )  //returns another df
    
    df1.show()
    
    val df2=df.select("_c1","_c3" )
    .groupBy("_c1").count()
    //.filter(df("_c1")==="12.5")  //give 3equls
    //.where("_c1=='12.5'")
    
    
    df2.show()
    
    
    
    
    
    
     
    
    
    
    
    
    
        
  }
}