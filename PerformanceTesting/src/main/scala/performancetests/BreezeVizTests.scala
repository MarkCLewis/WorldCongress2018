package performancetests

import data.CartAndRad
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import breeze.plot._
import java.awt.Color

object BreezeVizTests extends App {
  println("Load Data")
  val data = CartAndRad.read(new java.io.File("data/CartAndRad.88840.bin")).sortBy(_.x).drop(30).dropRight(10)
  println("Data Loaded " + data.size)

  val step = 1
  val x = (data.indices by step).map(i => data(i).x)
  val y = (data.indices by step).map(i => data(i).y)
  val z = (data.indices by step).map(i => data(i).z)
  val r = (data.indices by step).map(i => data(i).rad * 2)

  println("Start " + step)
  val start = System.nanoTime()

  val f = Figure()
  val p = f.subplot(0)
  p += scatter(x, y, r, _ => Color.BLACK)
  p.xlabel = "Radial"
  p.ylabel = "Azimuthal"
  p.title = "Sim"
  f.width = 2000
  f.height = 1500
//  Thread.sleep(30000)
//  f.saveas("breezeSimPlot.png")
  
  println((System.nanoTime() - start) * 1e-9)
}
