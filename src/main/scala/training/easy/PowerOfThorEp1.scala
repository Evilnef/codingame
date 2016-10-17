package training.easy

import scala.io.StdIn._

object PowerOfThorEp1 extends App {
  // lightx: the X position of the light of power
  // lighty: the Y position of the light of power
  // initialtx: Thor's starting X position
  // initialty: Thor's starting Y position
  var Array(lightX, lightY, currentX, currentY) = readLine.split(" ").map(_.toInt)
  while (true) {
    val (dirX, dirY) = (currentX compare lightX, currentY compare lightY)
    val result = Seq("S", "", "N")(dirY + 1) + Seq("E", "", "W")(dirX + 1)
    println(result)
    currentX -= dirX
    currentY -= dirY
  }
}