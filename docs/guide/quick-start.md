# 快速开始

## 后端

```shell
# 拉取core包
git clone https://gitee.com/FYMD/minion-core.git

cd minion-core
# 打包进本地maven仓库
mvn clean install

# 拉取代码
git clone https://gitee.com/FYMD/beluga.git

cd beluga
# 运行
mvn spring-boot:run -Ph2
```

## 前端

```shell
# 拉取代码
git clone -b beluga https://gitee.com/FYMD/avue-cli.git
# 初始化
yarn init # or npm i
# 运行
yarn run serve # or npm run serve
```