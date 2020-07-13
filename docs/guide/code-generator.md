# 代码生成器

代码生成器使用[minion-core-generate](https://gitee.com/FYMD/minion-core/tree/master/minion-core-generate)，minion-core-generate扩展mybatis-plus的代码生成器，支持多数据库代码生成，支持生成后端的Controller、不同分层的javabean（Param、Query、Dto、Entity）、Mapper、Service以及前端的curd代码。

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