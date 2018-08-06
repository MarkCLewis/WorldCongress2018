package performancetests

import data.CartAndRad
import swiftvis2.plotting.Plot
import swiftvis2.plotting.PlotSymbol
import swiftvis2.plotting.renderer.SwingRenderer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import swiftvis2.plotting.NumericAxis

object SwiftVis2SwingTests extends App {
  println("Load Data")
  val data = CartAndRad.read(new java.io.File("data/CartAndRad.88840.bin")).sortBy(_.x).drop(30).dropRight(30).sortBy(_.y).drop(30).dropRight(30)
  println("Data Loaded " + data.size)

  val step = 1
  val x = (data.indices by step).map(i => data(i).x)
  val y = (data.indices by step).map(i => data(i).y)
  val z = (data.indices by step).map(i => data(i).z)
  val r = (data.indices by step).map(i => data(i).rad * 2)

  println("Start " + step)
  val start = System.nanoTime()
  val plot = Plot.scatterPlot(x, y, "Sim", "Radial", "Azimuthal", r,
    xSizing = PlotSymbol.Sizing.Scaled, ySizing = PlotSymbol.Sizing.Scaled)
    .updatedAxis[NumericAxis]("x", axis => axis.copy(tickLabelInfo = axis.tickLabelInfo.map(_.copy(numberFormat = "%1.2f"))))
    .updatedAxis[NumericAxis]("y", axis => axis.copy(tickLabelInfo = axis.tickLabelInfo.map(_.copy(numberFormat = "%1.2f"))))
  SwingRenderer(plot, 2000, 1500, true)
  println((System.nanoTime() - start) * 1e-9)
}
