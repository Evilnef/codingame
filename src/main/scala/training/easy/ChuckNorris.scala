package training.easy

import scala.io.StdIn._

object ChuckNorris extends App {
  val message = readLine
  val encodedMsg = encodeMsg(message.flatMap(c => String.format("%7s", c.toBinaryString).replace(" ", "0")), new StringBuilder(), "e")
  println(encodedMsg.trim)

  def encodeMsg(msg: String, encodedMsg: StringBuilder, currentChar: String): String = {
    msg match {
      case m if m.startsWith(currentChar) => encodeMsg(msg.drop(1), encodedMsg.append('0'), currentChar)
      case m if m.startsWith("1") => encodeMsg(msg.drop(1), encodedMsg.append(" 0 0"), "1")
      case m if m.startsWith("0") => encodeMsg(msg.drop(1), encodedMsg.append(" 00 0"), "0")
      case _ => encodedMsg.toString()
    }
  }
}