package wc2018

import scalafx.application.JFXApp
import swiftvis2.plotting._
import swiftvis2.plotting.Plot
import swiftvis2.plotting.renderer.FXRenderer

object Facade1 extends JFXApp {
	val x = 1 to 10
	val y = x.map(x => x*x)

	val plot = Plot.scatterPlot(x, y, "Using Facade")
	
  FXRenderer(plot, 600, 600)
}