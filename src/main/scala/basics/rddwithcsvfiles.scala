package basics

import org.apache.spark.sql.SparkSession

object rddwithcsvfiles {
  
  def main(args:Array[String]){
    val spark=SparkSession.builder()
    .appName("creatingrdd with csv")
    .master("local")
    .getOrCreate()
    
    val csvrdd=spark.sparkContext.textFile("src/test/resources/housingdata.csv",14)
    
    println(csvrdd.count())
    
    csvrdd.collect().foreach(println)
    
    
    val header=csvrdd.first() // to get first line
    
    val csv=csvrdd.filter(_.contains(header))
    
    csv.take(10).foreach(println)
    
   // val csv1= csvrdd.filter(!(line=>line.contains(header)))
    
    val csv1=csvrdd.filter(line=>line !=header)
    
    csv1.take(10).foreach(println)
    
    val csvarray=csv1.map(line => line.split(",")(1))
    println("hey mananana")
     
    csvarray.take(10).foreach(println)
    
    
    
    val csv2=csv1.map(line=>{
      val colarray=line.split(",")
      List(colarray(0),colarray(1),colarray(2)) //if we give array refernece will be printed
          
    }).take(10).foreach(println)
    
    
     val csv3=csv1.map(line=>{
      val colarray=line.split(",")
      Array(colarray(0),",",colarray(1),colarray(2)).mkString("       ") //if we give array refernece will be printed
        
    })
    
    //csv2.take(10).foreach(println)
    
    //csv3.saveAsTextFile("outputs/csv3")  //no of parts generated in the output depends on the partitions
    
    
    
    
    
    
     
  }
  
}