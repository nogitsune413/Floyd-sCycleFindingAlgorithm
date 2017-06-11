import cycleFindingAlgorithm.ListAlgorithm

/**
  * リストを用いて、循環の検出を試みる。
  * Created by nakam on 2017/06/11.
  */
object ListAlgorithmTest {

  def main(args: Array[String]): Unit = {

    val dividend = 9 // 割られる数
    val divisor = 91 // 割る数

    // リストを用いて、循環の検出を試みる。
    new Test[ListAlgorithm].cycleFindingTest(dividend,divisor,new ListAlgorithm)
  }
}