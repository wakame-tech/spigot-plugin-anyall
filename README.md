# カスタムプラグインの作成 & 導入方法
## 1. ローカル環境にMineCraftサーバーを立てる
[nimmis/spigotイメージ](https://hub.docker.com/r/nimmis/spigot) を利用してマイクラサーバーのコンテナを作成します. 適当なディレクトリ(`<server>/` とする) 直下で `compose.yaml` を作成する

```yml
version: '3'

services:
  minecraft:
    image: nimmis/spigot
    ports:
      - "25565:25565"
    volumes:
      - .:/minecraft
    environment:
      - SPIGOT_VER=1.19.4
      - EULA=true
```

- コンテナを起動する

```bash
cd <server>/
docker compose up -d
```

- Minecraftを起動し, 「マルチプレイ」から `localhost:25565` に接続できるか試してください.

## 2. Spigotプラグインをビルドする
> 適宜 Spigotプラグインの参考実装(https://github.com/wakame-tech/spigot-plugin-anyall) を参考にしていただけると助かります

プラグインをビルドする.

```
cd <plugin/>
docker compose run gradle gradle build
```

ビルドが成功すれば `<plugin>/build/libs/<name>-<version>.jar` に実行ファイルが生成されます.
ローカルに立てたマイクラサーバーにプラグインをロードして動作を確認してみましょう.

```bash
cp <plugin>/build/libs/<name>-<version>.jar <server>/plugins
cd <server>/
docker compose exec minecraft mc_send "reload" # /reload コマンドでプラグインをリロードする
```

## 3. Spigotプラグインをリリースする
参考実装では, GitHub Actions workflowが用意されており, `main` ブランチにプッシュするとプラグインがビルドされて(プレ)リリースが作成されます.

![](https://i.imgur.com/4PJO1xk.png)

後は, DiscordにてリポジトリのURLを教えていただければこちらでそのプラグインを導入致します.