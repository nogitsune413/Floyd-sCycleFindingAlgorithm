package cycleFindingAlgorithm

/**
  * 循環を検出するアルゴリズムの仕様
  * Created by nakam on 2017/06/10.
  */
trait CycleFindingAlgorithm {

  /** アルゴリズムの名前 */
  def algorithmName: String

  /**
    * 循環節の開始位置と循環節の長さを算出する
    * @param dividend 割られる数
    * @param divisor 割る数
    * @return 循環節の開始位置と循環節の長さ
    */
  def execute(dividend:Int,divisor:Int) :CycleFindingResult
}