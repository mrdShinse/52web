Scenario: 0001 パラメータ-dataと-propのいずれかが存在しない場合に、コンソールにヘルプを表示する。

Given 初期化
When パラメータ無しでMain#main()を実行する
Then コンソールにヘルプを表示する

Scenario: 0002 パラメータ-dataと-propで指定されたパスに適切な拡張子のファイルが存在しない場合に、コンソールに存在しない旨を表示する。
Given 初期化
When Main#mainに-data, dummy.txt, -prop, dummy.txtを渡して実行する
Then コンソールに存在しない旨を表示する

