# 切换缓存框架

目前支持ehcahe、redis

## 方式一

修改`application.yml`中的`spring.cache.type`，支持的值：ehcache、redis

## 方式二

添加环境变量
```shell
BELUGA_CACHE_TYPE=redis
```

如果使用redis需要配置以下环境变量

```shell
# redis host，默认是localhost
BELUGA_REDIS_HOST=localhost
# redis 认证密码，默认为空
BELUGA_REDIS_PASSWORD
```