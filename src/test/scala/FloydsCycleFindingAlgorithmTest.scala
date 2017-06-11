import cycleFindingAlgorithm.{FloydsCycleFindingAlgorithm, ListAlgorithm}

/**
  * フロイドの循環検出法をテストする。
  * Created by nakam on 2017/06/10.
  */
object FloydsCycleFindingAlgorithmTest {

  def main(args: Array[String]): Unit = {

    val dividend = 9 // 割られる数
    val divisor = 74 // 割る数

    // フロイドの循環検出法をテストする。
    new Test[FloydsCycleFindingAlgorithm].cycleFindingTest(dividend,divisor,new FloydsCycleFindingAlgorithm)

  }
}