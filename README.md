# Floyd's Cycle Finding Algorithm

## 概要
分数の形で表された有理数から循環小数を算出するプログラムです。<br/>
以下の二つのアルゴリズムを使って、計算を試みます。

- リストを使って循環を検出する方法
- フロイドの循環検出法

実装にはScalaを用います。

## 使い方

テストクラスに有理数をハードコードして実行してください。

### リストを使った方法

```Scala
object ListAlgorithmTest {

  def main(args: Array[String]): Unit = {

    val dividend = 9 // 割られる数
    val divisor = 74 // 割る数

    // リストを用いて、循環の検出を試みる。
    new Test[ListAlgorithm].cycleFindingTest(dividend,divisor,new ListAlgorithm)
  }
}
```

### フロイドの循環検出法

```Scala
object FloydsCycleFindingAlgorithmTest {

  def main(args: Array[String]): Unit = {

    val dividend = 11 // 割られる数
    val divisor = 93  // 割る数

    // フロイドの循環検出法をテストする。
    new Test[FloydsCycleFindingAlgorithm].cycleFindingTest(dividend,divisor,new FloydsCycleFindingAlgorithm)

  }
}
```

## 出力例

```text
リストを用いた循環検出法

有理数
9/74

循環小数
   . . 
0.1216

循環節の開始位置：小数第2位, 循環節の長さ：3
```

```text
フロイドの循環検出法

有理数
11/93

循環小数
  .             . 
0.118279569892473

循環節の開始位置：小数第1位, 循環節の長さ：15
```
