import scala.annotation.tailrec

/**
  * Created by nakam on 2017/06/04.
  */
class FloydsCycleFindingAlgorithm {

  def execute(dividend:Int,divisor:Int) :FloydsCycleFindingAlgorithmResult = {
    val firstRemainder = new Remainder(dividend % divisor,0)
    val pointerA = findSameRemainders(firstRemainder, firstRemainder, divisor)
    val pointerC = getStartPoint(firstRemainder,pointerA,divisor)
    val length = getLength(pointerC,getNextRemainder(pointerC,divisor),divisor)

    println("有理数：" + dividend + "/" + divisor)
    printf("循環節の開始位置：小数第%d位, 循環節の長さ：%d%n",pointerC.index + 1,length)
    new FloydsCycleFindingAlgorithmResult(pointerC.index,length)
  }

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

class FloydsCycleFindingAlgorithmResult(val startPointIndex:Int, val length:Int)