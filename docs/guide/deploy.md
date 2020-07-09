# 部署

## fatjar

```shell
mvn clean package
```

打包jar包，`java -jar [jar]`执行

## docker

```
# 生成所需环境的jar包
mvn clean package

# 切换到beluga项目根路径
cd beluga

# 构建镜像
docker build -t beluga:1.0.0 .

# 运行
docker run --name buluga -p 8080:8080 -d beluga:1.0.0
```

docker使用-e设置环境变量

支持配置项
```shell
# redis host
BELUGA_REDIS_HOST
# redis密码
BELUGA_REDIS_PASSWORD

# 缓存类型(ehcache、redis)
BELUGA_CACHE_TYPE

# 数据库用户名
BELUGA_DB_USERNAME
# 数据库密码
BELUGA_DB_PASSWORD
# 数据库host
BELUGA_DB_HOST
# 数据库端口
BELUGA_DB_PORT
# 数据库名
BELUGA_DB_NAME
```

例子：切换缓存
```shell
docker run --name buluga -p 8080:8080 -d -e BELUGA_CACHE_TYPE=ehcache beluga:1.0.0
```