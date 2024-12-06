# Pokemon App

Jetpack Compose、Hilt、Room、Retrofit を使用して構築されたシンプルなポケモンアプリです。このアプリはポケモンAPIからデータを取得し、ポケモンを閲覧、詳細表示、お気に入り登録、またお気に入りのポケモン一覧を表示する機能を提供します。

## 特徴

- ポケモンリストの取得と表示
- 各ポケモンの詳細情報の表示（名前、身長、体重、スプライト）
- ポケモンのお気に入り登録・解除、お気に入りリストの表示
- ページネーションによる追加ポケモンの読み込み
- ダークモードおよびライトモードのサポート

## デモ

[untitled.webm](https://github.com/user-attachments/assets/35c45085-c52f-4c8a-80d7-18ee4288f3e5)

## 技術スタック

このプロジェクトは以下の技術を使用しています：

- **Kotlin 2.0.20**: プログラミング言語
- **Jetpack Compose**: UIツールキット
- **Hilt 2.52**: 依存性注入ライブラリ
- **Room 2.6.1**: ローカルデータベース
- **Retrofit 2.9.0**: API通信用のネットワーキングライブラリ
- **Coil 2.3.0**: 画像読み込みライブラリ
- **OkHttp 4.12.0**: HTTPクライアント
- **Navigation Compose 2.8.3**: Jetpack Compose ナビゲーション
- **Material3 1.3.0**: マテリアルデザインコンポーネント

## ディレクトリ構成

```
/app
    └── src/main/
        ├── java/
        │   └── com/example/myapp/
        │       ├── data/                # データ層
        │       │   ├── model/           # データモデル (e.g., Pokemon.kt)
        │       │   ├── local/           # RoomデータベースとDAO
        │       │   └── remote/          # Retrofit APIサービス
        │       ├── domain/              # ビジネスロジック層
        │       │   └── model/           # ドメインモデル
        │       ├── ui/                  # UI層
        │       │   ├── components/      # 再利用可能なUIコンポーネント
        │       │   ├── screens/         # スクリーンUI (PokemonListScreen, SettingsScreenなど)
        │       │   ├── state/           # UIステート管理 (e.g., PokemonListUiState)
        │       │   └── navigation/      # ナビゲーション設定 (PokemonNavGraph.kt)
        │       ├── viewmodel/           # ViewModel層
        │       └── di/                  # 依存性注入 (Hiltモジュール)
        └── res/
            ├── layout/                  # XMLレイアウトファイル (必要に応じて)
            ├── drawable/                # 画像アセット
            └── values/                  # 色、文字列、テーマ
```

## 必要要件

- Android Studio Flamingo以上
- Kotlin 2.0.x
- Gradle 8.1.1
- Android SDK 33以上

