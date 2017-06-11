package cycleFindingAlgorithm

import scala.annotation.tailrec

/**
  * リストを用いて、循環節の開始位置と循環節の長さを求める。
  * Created by nakam on 2017/06/10.
  */
class ListAlgorithm extends CycleFindingAlgorithm  {

  override def algorithmName: String = "リストを用いた循環検出法"

  override def execute(dividend: Int, divisor: Int): CycleFindingResult = {
    getCycleFindingResult(Seq.empty[Int] :+ dividend % divisor,divisor)
  }

  /**
    * 循環節の開始位置と循環節の長さを算出する
    * @param remainderList 余りのリスト
    * @param divisor 割る数
    * @return 循環節の開始位置と循環節の長さ
    */
  @tailrec
  private def getCycleFindingResult(remainderList:Seq[Int], divisor:Int): CycleFindingResult ={
    val nextRemainder = getNextRemainder(remainderList.last,divisor)
    if(remainderList.contains(nextRemainder)){
      val startIndex = remainderList.indexOf(nextRemainder)
      new CycleFindingResult(startIndex,remainderList.size - startIndex)
    } else {
      getCycleFindingResult(remainderList :+ nextRemainder,divisor)
    }
  }

  /**
    * 次の余りの数を得る
    * @param remainder 前の割り算の余り
    * @param divisor 割る数
    * @return 今回の割り算の余り
    */
  private def getNextRemainder(remainder:Int, divisor: Int): Int ={
    remainder * 10 % divisor
  }
}