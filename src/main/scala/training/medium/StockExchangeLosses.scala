package training.medium

import scala.io.StdIn._
import scala.math._

/**
  * Created by atsibin on 11.11.16.
  */
object StockExchangeLosses extends App {
  val n = readInt
  val series = readLine.split(" ").map(_.toInt).toList
  println(calculateLoss(series, 0, 0))

  def calculateLoss(series: List[Int], currentMax: Int, loss: Int): Int = series match {
    case h :: tail => calculateLoss(tail, max(currentMax, h), min(loss, h - currentMax))
    case Nil => loss
  }
}