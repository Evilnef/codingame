import scala.math._

atan2(-1, -1)

def calculateAngle(x1: Int, y1: Int, x2: Int, y2: Int) = {
  val dot = x1 * x2 + y1 * y2
  val det = x1 * y2 - y1 * x2
  atan2(det, dot)
}

calculateAngle(1, 1, 1, -1)