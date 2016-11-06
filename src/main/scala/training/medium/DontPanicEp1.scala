package training.medium

import scala.io.StdIn._

/**
  * Created by atsibin on 06.11.16.
  */
object DontPanicEp1 extends App {
  // nbfloors: number of floors
  // width: width of the area
  // nbrounds: maximum number of rounds
  // exitfloor: floor on which the exit is found
  // exitpos: position of the exit on its floor
  // nbtotalclones: number of generated clones
  // nbadditionalelevators: ignore (always zero)
  // nbelevators: number of elevators
  val Array(nbfloors, width, nbrounds, exitfloor, exitpos, nbtotalclones, nbadditionalelevators, nbelevators) = readLine.split(" ").map(_.toInt)
  // elevatorfloor: floor on which this elevator is found
  // elevatorpos: position of the elevator on its floor
  val elevators = (0 until nbelevators).map { i =>
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    (a, b)
  }.toMap
  val targets = elevators + (exitfloor -> exitpos)
  // game loop
  gameLoop()

  def gameLoop(): Unit = {
    // clonefloor: floor of the leading clone
    // clonepos: position of the leading clone on its floor
    // direction: direction of the leading clone: LEFT or RIGHT
    val Array(_clonefloor, _clonepos, direction) = readLine split " "
    val clonefloor = _clonefloor.toInt
    val clonepos = _clonepos.toInt
    Console.err.println(clonepos + " " + direction)

    (directionToElevator(targets.get(clonefloor), clonepos), direction) match {
      case ("EQUAL", _) => println("WAIT")
      case (d1, d2) if d1 == d2 => println("WAIT")
      case _ => println("BLOCK")
    }

    gameLoop()
  }

  def directionToElevator(elevatorPos: Option[Int], clonePos: Int) = {
    elevatorPos.map { pos => pos - clonePos match {
      case 0 => "EQUAL"
      case diff if diff < 0 => "LEFT"
      case _ => "RIGHT"
    }
    }.getOrElse("RIGHT")
  }
}
