import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper.Algorithm
import sun.security.util.Length

import scala.annotation.tailrec

/**
  * Created by nakam on 2017/06/10.
  */
object Ui {

  /**
    * 得られた答えをコンソール出力する
    * @param algorithmName 使用したアルゴリズム
    * @param dividend 割られる数
    * @param divisor 割る数
    * @param quotientList 循環小数を求める操作で得られた商のリスト
    * @param startPointIndex 循環小数の開始位置
    * @param length 循環節の長さ
    */
  def show(algorithmName: String, dividend:Int, divisor:Int, quotientList:Seq[Int], startPointIndex:Int, length: Int) : Unit = {
    println(algorithmName + "\n")
    println("有理数")
    println(dividend.toString + "/" + divisor.toString + "\n")
    println("循環小数")
    println(getAnswerStr1(new StringBuilder("  "), startPointIndex, length, 0))
    println(getAnswerStr2(new StringBuilder(), quotientList).toString() + "\n")
    printf("循環節の開始位置：小数第%d位, 循環節の長さ：%d%n", startPointIndex + 1, length)
  }

  /**
    * 循環小数を求める
    * @param answerStr 循環小数を表す文字列を逆順にした文字列
    * @param quotientList 循環小数を求める操作で得られた商のリスト
    * @return 循環小数を表す文字列
    */
  @tailrec
  def getAnswerStr2(answerStr: StringBuilder, quotientList: Seq[Int]): StringBuilder = {
    if (quotientList.size == 1) {
      answerStr ++= "."
    }
    answerStr ++= quotientList.last.toString
    if (quotientList.size == 1) {
      answerStr.reverse
    } else {
      getAnswerStr2(answerStr, quotientList.init)
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
