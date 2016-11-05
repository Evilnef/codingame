package training.medium

import scala.io.StdIn._

object SkynetRevolutionEp1 extends App {
  val Array(n, l, e) = readLine.split(" ").map(_.toInt)
  val arcs = (0 until l).map { _ =>
    val Array(n1, n2) = readLine.split(" ").map(_.toInt)
    (n1, n2)
  }

  val exits = (0 until e).map(_ => readInt)

  val exitsArc = arcs.filter(n => exits.contains(n._1) || exits.contains(n._2))

  gameCycle(exitsArc)

  def gameCycle(exitsArc: Seq[(Int, Int)]): String = {
    val si = readInt
    val exitNeighbor = exitsArc.find(a => a._1 == si || a._2 == si)
    val toBlock = exitNeighbor.getOrElse(exitsArc.head)

    println(s"${toBlock._1} ${toBlock._2}")
    gameCycle(exitsArc.diff(List(toBlock)))
  }
}
