# 切换数据库

目前提供mysql、oracle、h2的sql文件，但是理论上是支持所有mybatis支持的数据库的。

默认是`h2`

## Mysql

```sql
-- 创建数据库
create database beluga;
```

1. 按顺序导入`db`目录下的`mysql-1-schemas.sql`、`mysql-2-data.sql`

2. 后端项目maven切换profile为mysql，idea可以在右侧的maven栏中切换

3. 提供数据库的配置信息，在环境变量中添加以下变量（或者直接修改`application-mysql.yml`）

   ```shell
   # 数据库用户名，默认是root
   BELUGA_DB_USERNAME=root
   # 数据库密码，默认是root
   BELUGA_DB_PASSWORD=root
   # 数据库host，默认是localhost
   BELUGA_DB_HOST=localhost
   # 数据库端口，默认是3306
   BELUGA_DB_PORT=3306
   # 数据库名，默认是beluga
   BELUGA_DB_NAME=beluga
   ```

## Oracle

```sql
-- 创建数据库
create database beluga;
```

1. 按顺序导入`db`目录下的`oracle-1-schemas.sql`、`oracle-2-data.sql`

2. 后端项目maven切换profile为oracle，idea可以在右侧的maven栏中切换

3. 提供数据库的配置信息，在环境变量中添加以下变量（或者直接修改`application-oracle.yml`）

   ```shell
   # 数据库用户名，默认是root
   BELUGA_DB_USERNAME=root
   # 数据库密码，默认是root
   BELUGA_DB_PASSWORD=root
   # 数据库host，默认是localhost
   BELUGA_DB_HOST=localhost
   # 数据库端口，默认是1521
   BELUGA_DB_PORT=1521
   # 数据库名，默认是beluga
   BELUGA_DB_NAME=beluga
   ```

## 添加其它数据库

1. 参考`schemas`、`data`编写创建数据表和插入数据语句

2. 修改pom.xml，添加profile，例子：

   ```xml
   <!-- mysql -->
   <profile>
       <id>mysql</id>
       <activation>
           <activeByDefault>true</activeByDefault>
       </activation>
       <properties>
           <project.active>mysql</project.active>
       </properties>
       <dependencies>
           <!-- 数据库驱动 -->
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
           </dependency>
       </dependencies>
   </profile>
   ```

   