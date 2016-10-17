package training.medium

import scala.io.StdIn._

/**
  * Don't let the machines win. You are humanity's last hope...
  **/
object ThereIsNoSpoonEp1 extends App {
  var grid = Array.ofDim[Char](0, 0)
  val width = readInt // the number of cells on the X axis
  val height = readInt // the number of cells on the Y axis
  grid = Array.ofDim[Char](height, width)
  for (i <- 0 until height) {
    grid(i) = readLine.toArray
  }

  val nodes = grid.zipWithIndex.flatMap(r => r._1.zipWithIndex.filter(e => e._1 == '0').map(e => Node(e._2, r._2)))

  nodes.foreach(n => (n.right, n.bottom) match {
    case (Some(r), Some(b)) =>
      println(n.x + " " + n.y + " " + r.x + " " + r.y + " " + b.x + " " + b.y)
    case (Some(r), None) =>
      println(n.x + " " + n.y + " " + r.x + " " + r.y + " -1 -1")
    case (None, Some(b)) =>
      println(n.x + " " + n.y + " -1 -1 " + b.x + " " + b.y)
    case (None, None) =>
      println(n.x + " " + n.y + " -1 -1 -1 -1")
  })

  case class Node(x: Int, y: Int) {
    def right = nodes.find(n => n.y == y && n.x > x)
    def bottom = nodes.find(n => n.x == x && n.y > y)
  }
}