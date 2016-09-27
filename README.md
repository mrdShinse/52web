## 仕様

taskline(x.x)で作成したWBSをbacklogへAPI(x.x)経由でタスク登録する。

#### 対象操作

o 新規登録
x 更新
x 削除

#### 起動方法

java -jar 52web.jar -data hoge.xmlx -prop api.properties

#### 入力値と用途

|入力ソース|入力値名|backlog上の用途|
|:--:     |:--     |:--|
|taskline|タスク名  |課題名|
||担当者|担当者ID|
||開始日|開始日|
||終了日||
||工数|予定時間|
|api.properties|url|HTTPリクエスト送信先の親URL|
||username|登録ユーザーID|
||password|登録ユーザーのパスワード|
