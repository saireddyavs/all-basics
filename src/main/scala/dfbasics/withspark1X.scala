package dfbasics

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.Row



object withspark1X {
  
  def main(args:Array[String]){
    val spar=new SparkConf()
    .setMaster("local")
    .setAppName("creating data frame with spark 1X")
    val sc=new SparkContext(spar);
    
    val sql=new SQLContext(sc)  //in spark 1X df is created using sqlcontext and sqlcontext is created using spark context
       
    val rdd=sc.parallelize(Array(0,1,2,3,4,5,6,7))
    
    val schema=StructType(
    
        Array(
            StructField("numbers",IntegerType) ,
            StructField("numbers1",IntegerType)
        )
        
    )
    
    val rowrdd=rdd.map(line=>Row(line,line))  
    
    
    val df=sql.createDataFrame(rowrdd,schema)
    
    df.printSchema()
    
    df.show()
    
    //rowrdd.take(10).foreach(println)
    
  }
  
}