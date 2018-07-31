package wc2018

import scalafx.application.JFXApp
import swiftvis2.plotting._
import swiftvis2.plotting.renderer.FXRenderer
import swiftvis2.plotting.renderer.Renderer
import swiftvis2.plotting.styles.ScatterStyle

object LongForm extends JFXApp {
	val x = 1 to 10
	val y = x.map(x => x*x)

	val font = new Renderer.FontData("Ariel", Renderer.FontStyle.Plain)
	val style = ScatterStyle(x, y)
	val p2d = Plot2D(style, "x", "y")
	val xAxis = NumericAxis(tickLabelInfo = Some(Axis.LabelSettings(90, font, "%1.1f")), 
	    name = Some(Axis.NameSettings("X", font)))
	val yAxis = NumericAxis(tickLabelInfo = Some(Axis.LabelSettings(0, font, "%1.1f")), 
	    name = Some(Axis.NameSettings("Y", font)))
	val grid = PlotGrid(Seq(Seq(Seq(p2d))), Map("x" -> xAxis, "y" -> yAxis), Seq(1.0), Seq(1.0))
	val plot = Plot(grids = Map("main" -> Plot.GridData(grid, Bounds(0.0, 0.05, 0.95, 0.95))))
	FXRenderer(plot, 600, 600)
}
