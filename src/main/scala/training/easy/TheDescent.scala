package training.easy

import scala.io.StdIn._

object TheDescent extends App {
  while (true) {
    val mountainHeights = (0 until 8).map(_ => readInt())
    println(mountainHeights.zipWithIndex.maxBy(_._1)._2)
  }
}