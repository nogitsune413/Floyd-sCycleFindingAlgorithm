import scala.annotation.tailrec

/**
  * Created by nakam on 2017/05/29.
  */
object Test {

  def main(args: Array[String]): Unit = {

    val dividend = 9 // 割られる数
    val divisor = 74 // 割る数

    val result = FloydsCycleFindingAlgorithm.execute(dividend, divisor)
    val answer = Division.divided(dividend, divisor, List.empty[Int], result.startPointIndex + 1 + result.length)

    println("有理数")
    println(dividend.toString + "/" + divisor.toString)
    println()
    println("循環小数")
    println(getAnswerStr1(new StringBuilder("  "), result.startPointIndex, result.length, 0))
    println(getAnswerStr2(new StringBuilder(), answer))
    println()
    printf("循環節の開始位置：小数第%d位, 循環節の長さ：%d%n", result.startPointIndex + 1, result.length)
  }

  @tailrec
  def getAnswerStr2(str: StringBuilder, answer: Seq[Int]): StringBuilder = {
    if (answer.size == 1) {
      str ++= "."
    }
    str ++= answer.last.toString
    if (answer.size == 1) {
      str.reverse
    } else {
      getAnswerStr2(str, answer.init)
    }
  }

  @tailrec
  def getAnswerStr1(str: StringBuilder, startPointIndex: Int, length: Int, index: Int): StringBuilder = {
    val s = if (startPointIndex == index || startPointIndex + length - 1 == index) {
      "."
    } else {
      " "
    }
    if (startPointIndex + length == index) {
      str ++= s
    } else {
      getAnswerStr1(str ++= s, startPointIndex, length, index + 1)
    }
  }
}