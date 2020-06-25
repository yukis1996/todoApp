# **todoApp**

1.[内容・目的](#内容・目的)  
2.[ユースケース](#ユースケース)  
3.[ER図](#ER図)  
4.[画面遷移](#画面遷移)  
5.[頑張ったところ](#頑張ったところ)  

### *内容・目的*

* 期限付きのタスクを入力し自分のやることを整理できるアプリケーションを作成
* 期限に応じた検索機能を付けることで学生(課題提出)や社会人(今日の予定など)問わず使えるように
* 以前Rubyにてtodoアプリケーションを作成していたため、Javaでも実装できるようになろうと思った

<br>

### *ユースケース*

* ユーザー登録・認証(Spring Security)
* タスクを入力し保存する
* タスクに期限と優先度を設定できる
* ログインユーザーのタスクを一覧表示
* タスクの検索ができる

### *ER図*
![todoER](https://user-images.githubusercontent.com/58467980/85508616-64dacb00-b62f-11ea-8e5c-533e3443aecb.png)

### *画面遷移*
css調整後に画像挿入予定
下記は遷移のイメージ
![遷移](https://user-images.githubusercontent.com/58467980/85517172-f8b19480-b639-11ea-8683-ed20be374fcc.png)

### *頑張ったところ*
* Rubyの時にできていなかったenumを使った優先度の設定
* Spring Boot 並びに Spring Securityの大まかな流れや処理の理解(特にログインユーザー情報)
* Ajaxによる動的な見た目の変更
* SQLの検索表示(予定)

### *最後に*
シンプルなアプリの作成になってしましましたが、RubyとJavaの違いをよく考えながら作っていました（特に型）。
まだ時間が少しあるので見た目を整えることや追加機能の実装が行えたらと思っております。
