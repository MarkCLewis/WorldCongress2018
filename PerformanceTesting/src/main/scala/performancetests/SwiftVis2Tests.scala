package performancetests

import scalafx.application.JFXApp
import data.CartAndRad
import swiftvis2.plotting.Plot
import swiftvis2.plotting.PlotSymbol
import swiftvis2.plotting.renderer.FXRenderer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object SwiftVis2Tests extends JFXApp {
  val data = CartAndRad.read(new java.io.File("data/CartAndRad.88840.bin"))

  val steps = List(1000, 100, 10, 1)
  for (s <- steps) {
    val x = (data.indices by s).map(i => data(i).x)
    val y = (data.indices by s).map(i => data(i).y)
    val z = (data.indices by s).map(i => data(i).z)
    val r = (data.indices by s).map(i => data(i).rad * 2)

    Future {
      println("Start " + s)
      val start = System.nanoTime()
      val plot = Plot.scatterPlot(x, y, "Sim", "Radial", "Azimuthal", r,
        xSizing = PlotSymbol.Sizing.Scaled, ySizing = PlotSymbol.Sizing.Scaled)
      FXRenderer(plot, 800, 800)
      println((System.nanoTime() - start) * 1e-9)
    }
  }
}