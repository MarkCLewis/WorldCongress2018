package performancetests

import data.CartAndRad
//import vegas.DSL._

object VegasTests extends App {
  println("Load Data")
  val data = CartAndRad.read(new java.io.File("data/CartAndRad.88840.bin"))
  println("Data Loaded " + data.size)

  val step = 100
  val x = (data.indices by step).map(i => data(i).x)
  val y = (data.indices by step).map(i => data(i).y)
  val z = (data.indices by step).map(i => data(i).z)
  val r = (data.indices by step).map(i => data(i).rad * 2)

  println("Start " + step)
  val start = System.nanoTime()

  //Vegas("Sim", width = 800, height = 800)
    

  println((System.nanoTime() - start) * 1e-9)
}