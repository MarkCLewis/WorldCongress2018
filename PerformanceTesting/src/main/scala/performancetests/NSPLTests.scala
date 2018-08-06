package performancetests

import data.CartAndRad
import org.nspl._
import awtrenderer._

object NSPLTests extends App {
  println("Load Data")
  val data = CartAndRad.read(new java.io.File("data/CartAndRad.88840.bin"))
  println("Data Loaded " + data.size)

  val step = 10
  val x = (data.indices by step).map(i => data(i).x)
  val y = (data.indices by step).map(i => data(i).y)
  val z = (data.indices by step).map(i => data(i).z)
  val r = (data.indices by step).map(i => data(i).rad * 2)

  println("Start " + step)
  val start = System.nanoTime()

  val plot = xyplot((x, y))()
  show(plot)

  println((System.nanoTime() - start) * 1e-9)
}