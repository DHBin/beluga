# 代码生成器

代码生成器使用[minion-core-generate](https://gitee.com/FYMD/minion-core/tree/master/minion-core-generate)，minion-core-generate扩展mybatis-plus的代码生成器，支持多数据库代码生成，支持生成菜单sql、后端的Controller、不同分层的javabean（Param、Query、Dto、Entity）、Mapper、Service以及前端的curd代码。

## 在控制台生成代码

`test/java/cn.dhbin.beluga.generator/CodeGenerate`已经定义好了代码生成器的模板，可以根据自己项目的实际情况修改相关配置：

### 数据源配置

```java
// 数据源配置
DataSourceConfig dsc = new DataSourceConfig();
dsc.setUrl("jdbc:h2:file:./beluga");
dsc.setDriverName("org.h2.Driver");
dsc.setUsername(null);
dsc.setPassword(null);
mpg.setDataSource(dsc);
```

### 包配置

```java
// 包配置
PackageConfig pc = MinionGeneratorConfig.packageConfig("父包路径" , moduleName);
```

### 注入配置

```java
// 注入配置
InjectionConfig cfg = new MinionInjectionConfig((MinionGlobalConfig) gc, pc);
mpg.setCfg(cfg);
```

### 模板配置

```java
// 配置模板
TemplateConfig templateConfig = MinionGeneratorConfig.templateConfig();
mpg.setTemplate(templateConfig);
```

### 策略配置

```java
// 策略配置
MinionStrategyConfig strategy = MinionGeneratorConfig.strategyConfig();
// start 如果字段包含create_time、update_time、create_uid、update_uid，可以设置Entity父类为BaseEntity
//  strategy.setSuperEntityClass("cn.dhbin.minion.core.common.entity.BaseEntity");
//  strategy.setSuperEntityColumns("create_time", "update_time", "create_uid", "update_uid");
// 使用Spring Security注解鉴权
strategy.setSpringSecurityAnnotation(true);
// end
strategy.setTablePrefix("TEST_");
strategy.setInclude(scanner("表名").split(","));
mpg.setStrategy(strategy);
```

### 更多

[mybatis plus代码生成器配置](https://mybatis.plus/config/generator-config.html#基本配置)

# 使用

生成的代码在项目的`generate`文件夹里

- front文件夹：前端代码
- sql文件夹：菜单sql
- src文件夹：后端代码

## 前端代码

前端代码复制到前端项目中，打开`vue.config.js`添加api服务器代理路径，比如需要转发`/test`到`http://127.0.0.1:8081/test`

```js
--- a/vue.config.js
+++ b/vue.config.js
@@ -58,6 +58,13 @@ module.exports = {
               pathRewrite: {
                   '^/code': '/code'
               }
+          },
+          '/test': {
+              target: url,
+              ws: true,
+              pathRewrite: {
+                  '^/test': '/test'
+              }
           }
       }
     }
```

关于代理服务器的更多配置见：https://cli.vuejs.org/zh/config/#devserver-proxy

## sql

生成的sql需要人工修改下，比如生成的sql如下：

```sql
-- 主键id根据自己的项目情况填入
-- 修改“父父编号”，上一级菜单num
-- 替换全部“父编号”
insert into SYS_MENU
VALUES ('菜单id', '测试', '测试', '2', 'beluga', 'views/test/beluga',
        'el-icon-s-tools', '父编号', '父父编号', '父编号', '2020-07-13 02:06:59', null, 1, 1);
insert into SYS_MENU
VALUES ('列表id', '测试列表', '测试列表', '3', '', '', '', '父编号1', '父编号', '父编号1', '2020-07-13 02:06:59',
        null, 1, 1);
insert into SYS_MENU
VALUES ('新增按钮id', '新增测试', '新增测试', '3', '', '', '', '父编号2', '父编号', '父编号2', '2020-07-13 02:06:59',
        null, 1, 1);
insert into SYS_MENU
VALUES ('更新按钮id', '更新测试', '更新测试', '3', '', '', '', '父编号3', '父编号', '父编号3', '2020-07-13 02:06:59',
        null, 1, 1);
insert into SYS_MENU
VALUES ('删除按钮id', '删除测试', '删除测试', '3', '', '', '', '父编号4', '父编号', '父编号4', '2020-07-13 02:06:59',
        null, 1, 1);
```

修改后：

```sql
-- 主键id根据自己的项目情况填入
-- 修改“父父编号”，上一级菜单num
-- 替换全部“父编号”
insert into SYS_MENU
VALUES ('1', '测试', '测试', '2', 'beluga', 'views/test/beluga',
        'el-icon-s-tools', '11', '1', '11', '2020-07-13 02:06:59', null, 1, 1);
insert into SYS_MENU
VALUES ('2', '测试列表', '测试列表', '3', '', '', '', '111', '11', '111', '2020-07-13 02:06:59',
        null, 1, 1);
insert into SYS_MENU
VALUES ('3', '新增测试', '新增测试', '3', '', '', '', '112', '11', '112', '2020-07-13 02:06:59',
        null, 1, 1);
insert into SYS_MENU
VALUES ('4', '更新测试', '更新测试', '3', '', '', '', '113', '11', '113', '2020-07-13 02:06:59',
        null, 1, 1);
insert into SYS_MENU
VALUES ('5', '删除测试', '删除测试', '3', '', '', '', '114', '11', '114', '2020-07-13 02:06:59',
        null, 1, 1);


```

## 后端代码

复制到后端项目即可

> 生成的代码格式比较乱，使用idea的同学可以右击包名--> Reformat Code --> 选择Include subdirectories、Optimize imports--> Run，可以格式化代码和优化导入。