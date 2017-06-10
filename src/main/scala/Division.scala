import scala.annotation.tailrec

/**
  * 割り算
  * Created by nakam on 2017/06/04.
  */
object Division {

  /**
    * 割り算で小数点以下の値を求める。
    * @param dividend 割られる数
    * @param divisor 割る数
    * @param answer 算出済みの商
    * @param time 割り算の回数
    * @return
    */
  @tailrec
  def divided(dividend:Int, divisor:Int, answer:Seq[Int], time:Int): Seq[Int] ={
    val result = divided(dividend, divisor)
    val currentAnswer = answer :+ result.quotient
    if(time == 1){
      currentAnswer
    } else {
      divided(result.remainder * 10, divisor,currentAnswer,time - 1)
    }
  }

  /**
    * 割り算を行う。
    * @param dividend 割られる数
    * @param divisor 割る数
    * @return 商と余り
    */
  private def divided(dividend:Int, divisor:Int): DivisionResult ={
    new DivisionResult(dividend / divisor,dividend % divisor)
  }
}

/**
  * 割り算の結果
  * @param quotient 商　
  * @param remainder 余り
  */
class DivisionResult(val quotient:Int, val remainder:Int)
