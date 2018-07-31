package wc2018

import scalafx.application.JFXApp
import swiftvis2.plotting._
import swiftvis2.plotting.Plot
import swiftvis2.plotting.ColorGradient
import swiftvis2.plotting.renderer.FXRenderer

object Facade2 extends JFXApp {
  val x1 = (1 to 1000).map(_ => math.random)
  val y1 = x1.map(_ * math.random)
  val x2 = 0.0 to 1.1 by 0.01
  val y2 = x2.map(x => math.cos(10 * x * x))
  val x3 = (1 to 1000).map(_ => math.random * math.random)
  val y3 = x2.map(x => math.sin(10 * x * x))
  val c3 = x2.map(_ => math.random)
  val x4 = 0.01 to 1.1 by 0.01
  val y4 = x4.map(x => 0.01 / x)
  val cg = ColorGradient(0.0 -> BlackARGB, 0.5 -> RedARGB, 1.0 -> WhiteARGB)

  val plot = Plot.scatterPlotGrid(
    Seq(
      Seq((x1, y1, BlackARGB, 5), (x2, y2, BlueARGB, 5)),
      Seq((x3, y3, cg(c3), 10), (x4, y4, GreenARGB, 5))),
    "Plot Grid", "Shared X", "Shared Y")
  
  FXRenderer(plot)
}
