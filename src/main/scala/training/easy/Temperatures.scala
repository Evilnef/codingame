package training.easy

import scala.io.StdIn._

object Temperatures extends App {
  val n = readInt
  val temps = if (n == 0) 0
  else readLine.split(" ").map(_.toInt).minBy(t => (t.abs, t < 0))
  println(temps)
}