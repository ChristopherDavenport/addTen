package example.addten

import implicits._

object Main {

  def main(args: Array[String]): Unit = {
    println(10.addTen)
    println("Hello".addTen)
    println((Int.MaxValue - 10).addTen)
    println((Int.MaxValue - 9).addTen)
    println(Int.MaxValue.addTen)
    println(Int.MinValue.addTen)
  }

}