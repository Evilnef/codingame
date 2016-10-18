package training.easy

import scala.io.StdIn._

object MIMEType extends App {
  val n = readInt()
  val q = readInt()

  val extensions = (0 until n).map { _ =>
    val Array(ext, name) = readLine.split(" ")
    (ext.toLowerCase, name)
  }.toMap

  (0 until q)
    .map(_ => readLine)
    .map { line =>
      val dot = line.lastIndexOf('.')
      if (dot == -1) "" else line.substring(dot + 1)
    }
    .map(ext => extensions.getOrElse(ext.toLowerCase, "UNKNOWN"))
    .foreach(println)
}