package wc2018

import scalafx.application.JFXApp
import swiftvis2.plotting._
import swiftvis2.plotting.styles.BoxPlotStyle
import swiftvis2.plotting.styles.HistogramStyle
import swiftvis2.plotting.styles.ViolinPlotStyle
import swiftvis2.plotting.styles.ScatterStyle
import swiftvis2.plotting.renderer.FXRenderer

object Facade3 extends JFXApp {
  val xs = Array.fill(900)(math.random * 100)
  val ys = xs.map(_ => (math.random - 0.5) * (math.random - 0.5) * 4 + 1)
  val bins = 0.0 to 2.0 by 0.05
  val cnts = Array.fill(bins.length - 1)(0.0)
  for (y <- ys) {
    val bin = (y / 0.05).toInt
    if (bin >= 0 && bin < cnts.length) cnts(bin) += 1
  }
  val plot = Plot.row(Seq(
    ScatterStyle(xs, ys, symbolWidth = 5, symbolHeight = 5),
    HistogramStyle(bins, Seq(HistogramStyle.DataAndColor(cnts, GreenARGB)), binsOnX = false),
    BoxPlotStyle(Array("Distrib"), Array(ys)),
    ViolinPlotStyle(Array("Distrib"), Array(ys))), "Distributions", "Num X", "Categories", "Y")
  
  FXRenderer(plot)
}