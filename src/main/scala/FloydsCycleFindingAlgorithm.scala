import scala.annotation.tailrec

/**
  * フロイドの循環検出法
  * Created by nakam on 2017/06/04.
  */
object FloydsCycleFindingAlgorithm {

  /**
    * フロイドの循環検出法を実行する。
    * @param dividend 割られる数
    * @param divisor 割る数
    * @return 循環の開始位置と循環節の長さ
    */
  def execute(dividend:Int,divisor:Int) :FloydsCycleFindingAlgorithmResult = {
    val firstRemainder = new Remainder(dividend % divisor,0)
    val pointerA = findSameRemainders(firstRemainder, firstRemainder, divisor)
    val pointerC = getStartPoint(firstRemainder,pointerA,divisor)
    val length = getLength(pointerC,getNextRemainder(pointerC,divisor),divisor)
    new FloydsCycleFindingAlgorithmResult(pointerC.index,length)
  }

  /**
    * 循環節の長さを求める
    * @param pointerC 循環節の開始位置を指すポインタC
    * @param pointerD 循環節の終了位置を探すポインタD
    * @param divisor 割る数
    * @return　循環節の長さ
    */
  @tailrec
  private def getLength(pointerC:Remainder, pointerD:Remainder, divisor:Int): Int = {
    if(pointerC.number == pointerD.number){
      pointerD.index - pointerC.index
    } else {
      getLength(pointerC, getNextRemainder(pointerD,divisor), divisor)
    }
  }

  /**
    * 循環節の開始位置を見つける
    * @param pointerC ポインタC
    * @param pointerA ポインタA
    * @param divisor 割る数
    * @return 循環節の開始位置
    */
  @tailrec
  private def getStartPoint(pointerC:Remainder, pointerA:Remainder,divisor:Int): Remainder = {
    if(pointerC.number == pointerA.number) {
      pointerC
    } else {
      getStartPoint(getNextRemainder(pointerC,divisor),getNextRemainder(pointerA,divisor),divisor)
    }
  }

  /**
    * 同じ余りを見つける
    * @param pointerA ポインタA
    * @param pointerB ポインタB
    * @param divisor　割る数
    * @return 同じ余りが見つかったときのポインタA
    */
  @tailrec
  private def findSameRemainders(pointerA:Remainder, pointerB:Remainder, divisor:Int): Remainder ={
    val resultA = getNextRemainder(pointerA, divisor)
    val resultB = getNextRemainder(pointerB, divisor,2)
    if(resultA.number == resultB.number){
      resultA
    } else {
      findSameRemainders(resultA, resultB, divisor)
    }
  }

  /**
    * 指定したオフセット分先の余りを得る
    * @param remainder 現在の余り
    * @param divisor 割る数
    * @param offset オフセット
    * @return 先にある余り
    */
  @tailrec
  private def getNextRemainder(remainder: Remainder, divisor:Int, offset:Int):Remainder ={
    val newRemainder:Remainder = getNextRemainder(remainder, divisor)
    if(offset == 1) {
      newRemainder
    } else {
      getNextRemainder(newRemainder, divisor, offset - 1)
    }
  }

  /**
    * 次の余りを得る。
    * @param remainder 現在の余り
    * @param divisor 割る数
    * @return 次の余り
    */
  private def getNextRemainder(remainder: Remainder, divisor:Int): Remainder ={
    new Remainder(remainder.number * 10 % divisor, remainder.index + 1)
  }

  /**
    * 余り
    * @param number 余り
    * @param index 添え字
    */
  class Remainder(val number:Int, val index:Int)
}

/**
  * フロイドの循環検出法の結果
  * @param startPointIndex 循環の開始位置
  * @param length 循環節の長さ
  */
class FloydsCycleFindingAlgorithmResult(val startPointIndex:Int, val length:Int)