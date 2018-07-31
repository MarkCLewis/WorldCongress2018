package wc2018

import org.apache.spark.sql.SparkSession

object SimpleSQL extends App {
  val spark = SparkSession.builder.appName("Simple Application").master("local[*]").getOrCreate()
  import spark.implicits._
  
  spark.sparkContext.setLogLevel("ERROR")

  val data = spark.read.
    option("header", "true").
    option("inferSchema", "true").
    csv("data/SanAntonioTemps.csv")

  data.show()
  
  val tdiff = data.select('TMAX - 'TMIN)
  tdiff.show()
  
  val withDiff = data.withColumn("TDIFF", 'TMAX - 'TMIN)
  withDiff.show()
}
