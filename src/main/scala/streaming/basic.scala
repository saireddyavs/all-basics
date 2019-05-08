package streaming

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext

object basic {
  def main(args:Array[String]){
    
    
    val conf = new SparkConf().setMaster("local[4]").setAppName("Spark Streaming - PopularHashTags")
  val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val ssc=new StreamingContext(sc,Seconds(2))
    
    val lines=ssc.textFileStream("C://test/")
    
    val words=lines.flatMap(_.split(" "))

    
    val wordcount=words.map(l=>(l,1)).reduceByKey(_+_)
    
    wordcount.print()
    
    ssc.start()
    ssc.awaitTermination();
    
    
    
  }
}