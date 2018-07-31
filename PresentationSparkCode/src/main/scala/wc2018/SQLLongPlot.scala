package wc2018

import scalafx.application.JFXApp
import org.apache.spark.sql.SparkSession
import swiftvis2.plotting._
import swiftvis2.plotting.Plot
import swiftvis2.plotting.styles.ScatterStyle
import swiftvis2.plotting.renderer.FXRenderer
import swiftvis2.plotting.ColorGradient

object SQLLongPlot extends JFXApp {
  val spark = SparkSession.builder.appName("Simple Application").master("local[*]").getOrCreate()
  import spark.implicits._
  
  spark.sparkContext.setLogLevel("ERROR")

  val data = spark.read.
    option("header", "true").
    option("inferSchema", "true").
    csv("data/SanAntonioTemps.csv")

  val doy = data.select('JD).as[Double].collect
  val tmax = data.select('TMAX).as[Double].collect
  val tmin = data.select('TMIN).as[Double].collect
  val colors = ColorGradient(0.0 -> BlueARGB, 40.0 -> GreenARGB, 80.0 -> RedARGB)
  val plot = Plot.simple(ScatterStyle(doy, tmax, colors = colors(tmin)), "Temperatures", 
      "Day of Year", "High Temperature")
  FXRenderer(plot)
}