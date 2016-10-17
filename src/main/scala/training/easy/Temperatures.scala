import scala.io.StdIn._
import scala.math._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Solution extends App {
  val n = readInt
  val temps = readLine.split(" ").toStream.map(_.toInt).sortWith(abs(_) > abs(_))
  println(temps)
}