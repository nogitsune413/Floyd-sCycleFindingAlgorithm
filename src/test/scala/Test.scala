import cycleFindingAlgorithm.CycleFindingAlgorithm

/**
  * 循環小数を求めるテスト
  * Created by nakam on 2017/05/29.
  */
class Test[T <: CycleFindingAlgorithm] {

  def cycleFindingTest(dividend:Int, divisor:Int, cycleFindingAlgorithm: T): Unit = {

    // 循環の開始位置と循環節の長さを求める
    val result = cycleFindingAlgorithm.execute(dividend, divisor)

    // 循環小数そのものを求める
    val answer = Division.divided(dividend, divisor, Seq.empty[Int], result.startPointIndex + 1 + result.length)

    // 結果をコンソール出力する
    Ui.show(cycleFindingAlgorithm.algorithmName,dividend,divisor,answer,result.startPointIndex,result.length)
  }
}