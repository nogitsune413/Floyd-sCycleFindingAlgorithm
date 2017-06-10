import scala.annotation.tailrec

/**
  * フロイドの循環検出法を用いて、循環小数を求めるテスト
  * Created by nakam on 2017/05/29.
  */
object Test {

  def main(args: Array[String]): Unit = {

    val dividend = 9 // 割られる数
    val divisor = 74 // 割る数

    // フロイドの循環検出法を用いて、循環の開始位置と循環節の長さを求める
    val result = FloydsCycleFindingAlgorithm.execute(dividend, divisor)

    // 循環小数そのものを求める
    val answer = Division.divided(dividend, divisor, List.empty[Int], result.startPointIndex + 1 + result.length)

    // 得られた答えをコンソール出力する
    println("有理数")
    println(dividend.toString + "/" + divisor.toString + "\n")
    println("循環小数")
    println(getAnswerStr1(new StringBuilder("  "), result.startPointIndex, result.length, 0))
    println(getAnswerStr2(new StringBuilder(), answer).toString() + "\n")
    printf("循環節の開始位置：小数第%d位, 循環節の長さ：%d%n", result.startPointIndex + 1, result.length)
  }

  /**
    * 循環小数を求める
    * @param answerStr 循環小数を表す文字列を逆順にした文字列
    * @param answer 循環小数の各桁の数値を保持するリスト
    * @return 循環小数を表す文字列
    */
  @tailrec
  def getAnswerStr2(answerStr: StringBuilder, answer: Seq[Int]): StringBuilder = {
    if (answer.size == 1) {
      answerStr ++= "."
    }
    answerStr ++= answer.last.toString
    if (answer.size == 1) {
      answerStr.reverse
    } else {
      getAnswerStr2(answerStr, answer.init)
    }
  }

  /**
    * 循環節の最初の数字と最後の数字の上に点を打つ
    * @param str 循環小数の上に表示する文字列
    * @param startPointIndex 循環節の開始位置
    * @param length 循環節の長さ
    * @param index 現在の位置
    * @return 循環節の最初の数字と最後の数字の上に打つ点を含む文字列
    */
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