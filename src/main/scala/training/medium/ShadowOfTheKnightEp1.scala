package training.medium

import scala.io.StdIn._

/**
  * Created by atsibin on 06.11.16.
  */
object ShadowOfTheKnightEp1 extends App {
  val Array(w, h) = readLine.split(" ").map(_.toInt)
  val n = readLine
  val Array(x, y) = readLine.split(" ").map(_.toInt)
  gameLoop(x, y, 0, w, 0, h)

  def gameLoop(x: Int, y: Int, lowerX: Int, upperX: Int, lowerY: Int, upperY: Int): Unit = {
    val bombLocation = readLine
    bombLocation.foreach {
      case 'U' =>
      case 'R' =>
      case 'L' =>
      case 'D' =>
    }
    bombLocation match {
      case "U" =>
        val midY = middle(lowerY, y)
        println(x + " " + midY)
        gameLoop(x, midY, lowerX, upperX, lowerY, y)
      case "UR" =>
        val midX = middle(x, upperX)
        val midY = middle(lowerY, y)
        println(midX + " " + midY)
        gameLoop(midX, midY, x, upperX, lowerY, y)
      case "R" =>
        val midX = middle(x, upperX)
        println(midX + " " + y)
        gameLoop(midX, y, x, upperX, lowerY, upperY)
      case "DR" =>
        val midX = middle(x, upperX)
        val midY = middle(y, upperY)
        println(midX + " " + midY)
        gameLoop(midX, midY, x, upperX, y, upperY)
      case "D" =>
        val midY = middle(y, upperY)
        println(x + " " + midY)
        gameLoop(x, midY, lowerX, upperX, y, upperY)
      case "DL" =>
        val midX = middle(lowerX, x)
        val midY = middle(y, upperY)
        println(midX + " " + midY)
        gameLoop(midX, midY, lowerX, x, y, upperY)
      case "L" =>
        val midX = middle(lowerX, x)
        println(midX + " " + y)
        gameLoop(midX, y, lowerX, x, lowerY, upperY)
      case "UL" =>
        val midX = middle(lowerX, x)
        val midY = middle(lowerY, y)
        println(midX + " " + midY)
        gameLoop(midX, midY, lowerX, x, lowerY, y)
    }
  }

  def middle(a: Int, b: Int) = (a + b) / 2
}
