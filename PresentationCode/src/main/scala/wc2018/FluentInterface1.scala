package wc2018

import scalafx.application.JFXApp
import swiftvis2.plotting._
import swiftvis2.plotting.Plot
import swiftvis2.plotting.renderer.FXRenderer
import swiftvis2.plotting.styles.ScatterStyle
import swiftvis2.plotting.NumericAxis

object FluentInterface1 extends JFXApp {
	val x = 1 to 10
	val y = x.map(x => x*x)

	val plot = Plot.scatterPlot(x, y, "Using Facade", "x", "y")	
  FXRenderer(plot, 600, 600)
  
  val plot2 = plot.updatedAxis[NumericAxis]("y", _.updatedName("Value"))
  FXRenderer(plot2, 600, 600)
}