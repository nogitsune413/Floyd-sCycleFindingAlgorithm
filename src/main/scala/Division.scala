import scala.annotation.tailrec

/**
  * Created by nakam on 2017/06/04.
  */
object Division {

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

  private def divided(dividend:Int, divisor:Int): DivisionResult ={
    new DivisionResult(dividend / divisor,dividend % divisor)
  }
}

class DivisionResult(val quotient:Int, val remainder:Int)
