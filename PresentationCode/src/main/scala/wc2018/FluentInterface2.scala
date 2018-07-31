package wc2018

import scalafx.application.JFXApp
import swiftvis2.plotting._
import swiftvis2.plotting.Plot
import swiftvis2.plotting.renderer.FXRenderer
import swiftvis2.plotting.styles.ScatterStyle
import swiftvis2.plotting.NumericAxis

object FluentInterface2 extends JFXApp {
  val alt = Array(-0.6, 11, 20, 32, 47, 51, 71, 84.852)
  val temp = Array(19.0, -56.5, -56.5, -44.5, -2.5, -2.5, -58.5, -86.38)
  val pressure = Array(108900, 22632, 5474.9, 868.02, 110.91, 66.939, 3.9564, 0.3734)

  val plot = Plot.stacked(
    Seq(
    ScatterStyle(temp, alt, lines = ScatterStyle.connectAll),
    ScatterStyle(pressure, alt, lines = ScatterStyle.connectAll, symbol = Rectangle)),
    "Temp and Pressure", "Temperature [C]", "Altitude [km]").
    withModifiedAxis[NumericAxis]("x", "pressure",
      _.asMaxSideXAxis
        .updatedScaleStyle(Axis.ScaleStyle.LogSparse)
        .updatedName("Pressure [Pa]")).
      updatedStyleXAxis("pressure", stack = 1)

  FXRenderer(plot)
}